package HashMaps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Get recommended tweets for a user from his following graph and like graph.
 */

/**
 * @author blessonm
 *
 */
public class RecTweets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecTweets rec = new RecTweets();
	}

	static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, 
            int targetUser, int minLikeThreshold) {
		HashSet<Integer> following = new HashSet<>();		
		for(int i=0; i<followGraph_edges.length; i++){
			if(followGraph_edges[i][0] == targetUser){
				following.add(followGraph_edges[i][1]);
			}
		}
		HashMap<Integer, Integer> likes = new HashMap<>();	
		for(int i=0; i<likeGraph_edges.length; i++){
			if(following.contains(likeGraph_edges[i][0])){
				if(likes.containsKey(likeGraph_edges[i][1]))
					likes.put(likeGraph_edges[i][1], likes.get(likeGraph_edges[i][1]+1));
				else
					likes.put(likeGraph_edges[i][1], 1);
			}
		}
		List<Integer> list = new ArrayList<>();
		for(Integer tweet: likes.keySet()){
			if(likes.get(tweet)>=minLikeThreshold)
				list.add(tweet);
		}
			
		Collections.sort(list);
		
		return list.stream().mapToInt(i->i).toArray();
	}
}
