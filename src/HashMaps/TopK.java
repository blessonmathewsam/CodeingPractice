package HashMaps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author blessonm
 *
 */ 
public class TopK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(topKFrequent(new int[] {1,2,2,3,3,4,5,6,7,8,9,10},2));

	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        List<Integer> list = new ArrayList<>();
        while(k > 0){
	        Map.Entry<Integer, Integer> maxEntry = null;
	        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	        	if(maxEntry == null || entry.getValue() > maxEntry.getValue())
	        		maxEntry = entry;
	        }
	        list.add(maxEntry.getKey());
	        map.remove(maxEntry.getKey());
	        k--;
        }
        return list;
    }
}
