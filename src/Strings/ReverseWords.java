/**
 * 
 */
package Strings;

/**
 * @author blessonm
 *
 */
public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseWords r = new ReverseWords();
		System.out.println(r.reverseWords(" "));
	}
	
	public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int j = str.length-1; j >= 0; j--){
        	sb.append(str[j]+" ");
        }
        return sb.toString();
    }

}
