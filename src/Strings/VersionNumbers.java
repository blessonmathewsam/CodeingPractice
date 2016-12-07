/**
 * 
 */
package Strings;

/**
 * @author blessonm
 *
 */
public class VersionNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String version1 = "1.0";
		String version2 = "2.0";
		String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        System.out.println(s1.length);
        System.out.println(s2.length);
	}

}
