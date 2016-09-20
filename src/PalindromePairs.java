import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class PalindromePairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(palindromePairs(new String[]{"a", ""}));
	}

	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < words.length; i++)
			map.put(words[i], i);
		for(int i = 0; i < words.length; i++){
			for(int j = 0; j <= words[i].length(); j++){
				String s1 = words[i].substring(0, j);
				String s2 = words[i].substring(j);
				
				if(isPal(s1)){
					String rev = new StringBuilder(s2).reverse().toString();
					if(map.containsKey(rev) && map.get(rev) != i){
						List<Integer> newList = new ArrayList<>();
						newList.add(map.get(rev));
						newList.add(i);
						list.add(newList);
					}
				}
				if(isPal(s2)){
					String rev = new StringBuilder(s1).reverse().toString();
					if(map.containsKey(rev) && map.get(rev) != i && s2.length() != 0){
						List<Integer> newList = new ArrayList<>();
						newList.add(i);
						newList.add(map.get(rev));
						list.add(newList);
					}
				}
			}
		}
		return list;
    }
	
	private static boolean isPal(String s) {
		int i = 0, j = s.length() - 1;
		while(i <= j){
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
