/**
 * 
 */
package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blessonm
 *
 */
public class GenerateParantheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateParantheses g = new GenerateParantheses();
		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<>();
		g.generate(0, 0, sb, 0, 0, result);
		for (String s: result) {
			System.out.println(s);
		}
	}
	
	public void generate(int pos, int n, StringBuilder sb, int open, int close, List<String> result){
		if(close == n){
			result.add(sb.toString());
		}
		if(open > close){
			sb.append(')');
			generate(pos, n, sb, open, close+1, result);
			sb.deleteCharAt(sb.length()-1);
		}
		if(open < n){
			sb.append('(');
			generate(pos, n, sb, open+1, close, result);
			sb.deleteCharAt(sb.length()-1);
		}
	}

}
