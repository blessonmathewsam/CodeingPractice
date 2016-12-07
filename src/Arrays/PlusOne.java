/**
 * 
 */
package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blessonm
 *
 */
public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(9);
		list.add(0);
		list.set(list.size()-1, list.get(list.size()-1)+1);
		for (int i = list.size()-1; i > 0 && list.get(i) == 10; i--) {
			list.set(i, 0);
			list.set(i-1, list.get(i-1)+1);
		}
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i));
		}
	}

}
