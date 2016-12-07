/**
 * 
 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author blessonm
 *
 */
public class QuadCombinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuadCombinations q = new QuadCombinations();
		int[] arr = new int[] {0,1,2,3,-1,-2};
		Set<List<Integer>> quadCombs = q.findQuadCombs(arr, 0);
		for(List<Integer> list: quadCombs){
			for(Integer n: list){
				System.out.print(n+" ");
			}
			System.out.println();
		}
	}
	
	public Set<List<Integer>> findQuadCombs(int[] arr, int sum){
		Set<List<Integer>> result = new HashSet<>();
		HashMap<Integer, Integer[]> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			for(int j = i+1; j < arr.length; j++){
				if(!map.containsKey(arr[i]+arr[j])){
					map.put(arr[i]+arr[j], new Integer[] {i, j});
				}
			}
		}
		
		for(Integer pairSum: map.keySet()){
			if(map.containsKey(sum-pairSum)){
				if(uniqueIndexes(map, map.get(pairSum), map.get(sum-pairSum))){
					Integer[] A = map.get(pairSum);
					Integer[] B = map.get(sum - pairSum);
					List<Integer> list = Arrays.asList(new Integer[] {A[0], A[1], B[0], B[1]});
					Collections.sort(list);
					result.add(list);
				}
			}
		}
		return result;
	}
	
	public boolean uniqueIndexes(HashMap<Integer, Integer[]> map, Integer[] A, Integer[] B){
		if(A[0] == B[0] || A[1] == B[1] || A[1] == B[0] || A[0] == B[1])
			return false;
		return true;
	}

}
