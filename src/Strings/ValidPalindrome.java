/**
 * 
 */
package Strings;

/**
 * @author blessonm
 *
 */
public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome("testtset"));		
	}
	
	public boolean isPalindrome(String s) {
        if(s.length() < 2)
            return true;
        s = s.replace("\n", "").replace("\r", "");
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return checkPalindrome(s, 0, s.length()-1);
    }
    
    public boolean checkPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

}
