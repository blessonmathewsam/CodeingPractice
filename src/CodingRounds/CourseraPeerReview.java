package CodingRounds;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author blessonm
 *
 */

/*Simulate the working of Coursera Peer Review System for D ticks and N learners.*/

public class CourseraPeerReview {
   
    /**
	 * @param args
	 */
	private static final int WAITING = 0; //To indicate whether learner is in waiting state
	private static final int WORKING = 1; //To indicate whether learner is in working state
	private static final int WORKINGTIME = 50; //Working time for submission
	private static final int REVIEWTIME = 20; //Working time for reviewing
	private static final int SUBMISSION = 0; //To indicate whether the learner was working on a submission 
	private static final int REVIEW = 1; //To indicate whether the learner was working on a review
    
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
		int D = in.nextInt(); //Number of ticks
		int N = in.nextInt(); //Number of learners
		Learner[] learners = new Learner[N];
		for (int i = 0; i < N; i++) {
			Learner learner = new Learner();
			learner.setLearnerId(in.nextInt());
			learner.setFirstSubmissionStartTime(in.nextInt());
			learner.setFirstSubmissionTrueGrade(in.nextInt());
			learner.setReviewBias(in.nextInt());
			learners[i] = learner;
		}
		CourseraPeerReview c = new CourseraPeerReview();
		c.simulate(learners, D, N); //Start the simulation
		c.printOutput(learners, N);
    }
    
   /**
     * Run the simulation of the peer review system for given number of ticks and number of learners
	 * @param learners
	 * @param D
	 * @param N
	 */ 
   public void simulate(Learner[] learners, int D, int N) {
		if(null == learners || learners.length == 0)
			throw new IllegalArgumentException("Please provide a list of learners as input");
		
		Comparator<Submission> comparator = new SubmissionComparator();
		List<PriorityQueue<Submission>> queues = new ArrayList<>();
		try {
			initializeSubmissionQueue(N, comparator, queues);
			
			for (int tick = 0; tick < D; tick++) {
				for (int i = 0; i < N; i++) {
					Learner learner = learners[i];
					if (!learner.started) { 
						isFirstSubmission(tick, learner); //Check if it is not yet learner's first submission start time
					} else {
						if (learner.state == WORKING) { //Check if the learner is working. If working then decrement the remaining work time.
							if (learner.remainingWork > 0)
								learner.remainingWork--;
							else {
								if (learner.workType == SUBMISSION) { //If work is done then check if learner was working on a submission 
									learner.submit(tick); //Submit 
									learner.submissions.add(learner.currentSubmission); //Submission added to list of submissions by learner
									for (int j = 0; j < N; j++) {
										if (j != i)
											queues.get(j).add(learner.currentSubmission); //Submission added to queues except learner's
									}
								} else if (learner.workType == REVIEW) { //If work is done then check if learner was working on a review 
									learner.currentReview.addReview(learner.reviewBias, tick); //Add review to submission
								}
								learner.state = WAITING;
							}
						}
					}
				}

				for (int i = 0; i < N; i++) {
					Learner learner = learners[i];
					if (learner.started && learner.state == WAITING) {
                        if (learnerGradeCheck(learner) ) { //Check if learner failed
                            setLearnerProperties(learner, WORKING, SUBMISSION, WORKINGTIME-1); //Start working again on his/her submission
                            continue;
                        }

                        //Check if there are submissions to review in queue and number of submissions reviewed less than limit
                        if (queues.get(i).size() > 0 && learner.reviewed < learner.maxReview) { 					
                            Submission submission = getCorrectSubmission(learner, queues, tick, i); //Get correct submission from queue to be reviewed
                            if (submission != null) { 
                                submission.reviewers.add(learner.learnerId); //Start review
                                learner.startReview(submission); 
                                setLearnerProperties(learner, WORKING, REVIEW, REVIEWTIME-1);
                                continue;
                            }
                        }
					}
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
	 * Initialize PriorityQueues for each learner and add to the lsit of queues
	 * @param N
	 * @param comparator
	 * @param queues
	 */
	private void initializeSubmissionQueue(int N, Comparator<Submission> comparator, List<PriorityQueue<Submission>> queues) {
		for (int i = 0; i < N; i++) {
			PriorityQueue<Submission> queue = new PriorityQueue<>(20, comparator);
			queues.add(queue);
		}
	}
    
    /**
	 * Check if it is learner's first submission start time
	 * @param tick
	 * @param learner
	 */
	private void isFirstSubmission(int tick, Learner learner) {
		if (tick == learner.firstSubmissionStartTime) {
			learner.started = true;
			setLearnerProperties(learner, WORKING, SUBMISSION, WORKINGTIME - 1);
		}
	}
    
    /**
	 * Set the parameters passed as the learner properties
	 * @param learner
	 * @param state
	 * @param workType
	 * @param remainingWork
	 */
	private void setLearnerProperties(Learner learner, int state, int workType, int remainingWork) {
		learner.state = state;
		learner.workType = workType;
		learner.remainingWork = remainingWork;
	}
    
    /**
	 * Check if submission has been graded and if it is less than 240
	 * @param learner
	 * @return
	 */
	private boolean learnerGradeCheck(Learner learner) {
		return learner.currentSubmission != null && learner.currentSubmission.gradeTick != -1 && learner.currentSubmission.scoreSum < 240;
    }
    
    /**
     * Ensure the submission was not made in the current tick   
     * Remove submissions that have already been graded
     * Make sure that less than 3 people are reviewing it at the moment
     * Make sure the learner has not reviewed this submission already
	 * @param learner
     * @param queues
	 * @param tick
	 * @param i
	 * @return
	 */
	private Submission getCorrectSubmission(Learner learner, List<PriorityQueue<Submission>> queues, int tick, int i) {
		PriorityQueue<Submission> currentQueue = queues.get(i);
		Submission submission = null;
		while (currentQueue.size() > 0 && currentQueue.peek().submissionTick < tick) {
			submission = currentQueue.remove();
			if (submission.gradeTick == -1 && submission.reviewers.size() < 3 && !submission.reviewers.contains(learner.learnerId)) {
				break;
			}
		}
		return submission;
	}

	public void printOutput(Learner[] learners, int N) {
		for (int i = 0; i < N; i++) {
			for (Submission submission : learners[i].submissions) {
				System.out.println(submission.learnerId + " " + submission.sequenceNumber + " "
						+ submission.submissionTick + " " + submission.scoreSum + " " + submission.gradeTick);
			}
		}
	}

	public static class Learner {
		protected boolean started;
		protected int learnerId;
		protected int firstSubmissionStartTime;
		protected int firstSubmissionTrueGrade;
		protected int reviewBias;
		protected int scoreSum;
		protected int state;
		protected int remainingWork;
		protected int sequenceNumber;
		protected int workType; //Type work the learner is doing. Could be SUBMISSION or REVIEW
		protected int reviewed; //Total number of submissions reviewed
		protected int maxReview; //Total number of reviews the learner can review
		protected List<Submission> submissions; //List of submissions made
		protected Submission currentSubmission; //Last submission made
		protected Submission currentReview; //Current submission the learner is reviewing
		
		//Constructor
		public Learner() {
			state = WAITING;
			remainingWork = 0;
			started = false;
			sequenceNumber = 0;
			submissions = new ArrayList<>();
			maxReview = 0;
		}

		public void setLearnerId(int learnerId) {
			this.learnerId = learnerId;
		}

		public void setFirstSubmissionStartTime(int firstSubmissionStartTime) {
			this.firstSubmissionStartTime = firstSubmissionStartTime;
		}

		public void setFirstSubmissionTrueGrade(int firstSubmissionTrueGrade) {
			this.firstSubmissionTrueGrade = firstSubmissionTrueGrade;
		}

		public void setReviewBias(int reviewBias) {
			this.reviewBias = reviewBias;
		}

        //Creates a new instance of Submission and assigns it to the currentSubmission attribute of the current instance of Learner
		public void submit(int tick) {
			currentSubmission = new Submission(learnerId, firstSubmissionTrueGrade, sequenceNumber, tick);
			sequenceNumber++; //Increment sequenceNumber after each submission
			reviewed = 0;
			maxReview += 3; //After each submission add 3 to the maximum number of reviews a learner can do
		}

        //
		public void startReview(Submission submission) {
			currentReview = submission;
			reviewed++;
		}
	}
	
	public static class Submission {
		protected int learnerId;
        protected int firstSubmissionTrueGrade;
		protected int sequenceNumber;
		protected int submissionTick;
		protected int scoreSum;
		protected int gradeTick;
		protected int reviewCount; //Number of reviews submitted
		protected Set<Integer> reviewers; //Set if learnerIds of learners reviewing the submission
		
		//Constructor
		public Submission(int learnerId, int firstSubmissionTrueGrade, int sequenceNumber, int tick) {
			this.learnerId = learnerId;
            this.firstSubmissionTrueGrade = firstSubmissionTrueGrade;
			this.sequenceNumber = sequenceNumber;
			submissionTick = tick;
			scoreSum = 0;
			gradeTick = -1;
			reviewers = new HashSet<>();
			reviewCount = 0;
		}
		
		//Adds a review to this submission
		public void addReview(int bias, int tick) {
			if (reviewCount < 3) {
                //Calulate scoreSum. scoreSum value will be between 0 and 100 inclusive
				scoreSum += Math.min(Math.max(0, firstSubmissionTrueGrade + (15 * sequenceNumber) + bias), 100);
				reviewCount++;
				if (reviewCount == 3) {
					gradeTick = tick;
				}
			}
		}
	}
	
	/*
	 * Submission comparator - To make sure the PriorityQueue remains sorted in the order of submissionTick
     * If there are two submissions with equal submissionTick, then they are ordered based on learnerId
	 */
	public static class SubmissionComparator implements Comparator<Submission> {
		public int compare(Submission o1, Submission o2) {
			if (o1.submissionTick > o2.submissionTick)
				return 1;
			else if (o1.submissionTick < o2.submissionTick)
				return -1;
			else {
				if (o1.learnerId > o2.learnerId)
					return 1;
				else if (o1.learnerId < o2.learnerId)
					return -1;
				else
					return 0;
			}
		}

	}
}