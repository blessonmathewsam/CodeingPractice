import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class NumberOfWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n<3){
			System.out.print(0);
		}
		else{
			int i = 0;
			int[] arr = new int[n];
			long sum = 0;
			while(i<n){
				arr[i] = in.nextInt();
				sum += arr[i];
				i++;
			}
			if(sum%3!=0){
				System.out.print(0);
			}
			else{
				long s = sum/3;
				long ways = 0;
				long count = 0;
				long tempSum = 0;
				i = 0;
				while(i<arr.length-1){
					tempSum += arr[i];
					if(tempSum==2*s)
						ways += count;
					if(tempSum==s)
						count++;
					i++;
				}
				System.out.println(ways);
			}
		}
	}

}
