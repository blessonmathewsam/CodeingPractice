package Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class StringPerm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcd";
		String temp;
		List<String> list = new ArrayList<>();
		for(int i = 0; i < (int) Math.pow(2, s.length()); i++){
			temp = "";
			for (int j = 0; j < s.length(); j++) {
				if(((i>>j) & 1) == 1)
					temp += s.charAt(j);
			}
			if(!temp.equals(""))
				list.add(temp);
		}
		Collections.sort(list);
		for(String st: list){
			System.out.println(st);
		}
	}
}
