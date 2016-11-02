package Strings;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class FillInTheBlanks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "I am coding in java";
		String s2 = "am in java";
		String[] s1Arr = s1.split(" ");
		String[] s2Arr = s2.split(" ");
		List<String> list = new ArrayList<>();
		for (int i = 0, m = 0; i < s1Arr.length; i++) {
			if(!s1Arr[i].equals(s2Arr[m]))
				list.add(s1Arr[i]);
			else
				m++;
		}
		for (String s: list) 
			System.out.print(s+" ");
	}

}
