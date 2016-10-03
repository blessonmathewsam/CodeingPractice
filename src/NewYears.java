import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class NewYears {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int x2 = in.nextInt();
		int x3 = in.nextInt();
		int temp = 0;
		if(x1>x2){
			temp = x1;
			x1 = x2;
			x2 = temp;
		}
		if(x1>x3){
			temp = x1;
			x1 = x3;
			x3 = temp;
		}
		if(x2>x3){
			temp = x2;
			x2 = x3;
			x3 = temp;
		}		
		System.out.println((x2-x1)+(x3-x2));
	}

}
