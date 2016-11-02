import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class PriorityQ {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Comparator<Student> comparator = new StudentComparator();
		PriorityQueue<Student> queue = new PriorityQueue<>(10, comparator);
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine();
		for(int i = 0; i < N; i++){
			queue.add(new Student(in.nextInt(), in.nextLine()));
		}
		while(queue.size()!=0){
			Student student = queue.remove();
			System.out.println(student.id+" "+student.name);
		}
	}
	
	public static class Student{
		int id;
		String name;
		
		Student(int id, String name){
			this.id = id;
			this.name = name;
		}
	}
	
	public static class StudentComparator implements Comparator<Student>{

		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Student arg0, Student arg1) {
			if(arg0.id>arg1.id)
				return 1;
			else if(arg0.id<arg1.id)
				return -1;
			else{
				return arg0.name.compareTo(arg1.name);				
			}
		}
		
	}

}
