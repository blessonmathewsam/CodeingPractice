/**
 * 
 */
package Strings;

/**
 * @author blessonm
 *
 */
public class BinaryString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "00110";
		System.out.println(count(s));
	}

	public static int count(String s){
		int count = 0;
		for (int i = 0; i < s.length()-1; i++) {
			if((s.charAt(i) == '0' && s.charAt(i+1) == '1') || (s.charAt(i) == '1' && s.charAt(i+1) == '0')){
				count++;
				int j = i-1;
				int k = i+2;
				if(s.charAt(i) == '0'){
					while(j>=0 && k<s.length() && s.charAt(j)=='0' && s.charAt(k)=='1'){
						count++;
						j--;
						k++;
					}
				}
				else{
					while(j>=0 && k<s.length() && s.charAt(j)=='1' && s.charAt(k)=='0'){
						count++;
						j--;
						k++;
					}
				}
			}
		}
		return count;
	}
}
