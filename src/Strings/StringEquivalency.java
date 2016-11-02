package Strings;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class StringEquivalency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		if(s1.length()!=s2.length()){
			System.out.print("NO");
		}
		else{
			if(s1.equals(s2)){
				System.out.print("YES");		
			}
			else{
				if(s1.length()%2!=0)
					System.out.print("NO");
				else{
					if(smallest(s1).equals(smallest(s2)))
						System.out.println("YES");
					else
						System.out.println("NO");
				}
			}
		}
	}
	
	public static String smallest(String s){
		if(s.length()%2==1)
			return s;
		String s1 = smallest(s.substring(0, s.length()/2));
		String s2 = smallest(s.substring(s.length()/2, s.length()));
		if(s1.compareTo(s2)<0)
			return s1+s2;
		else
			return s2+s1;
	}

}
