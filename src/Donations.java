import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class Donations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while(i<n){
			arr[i] =in.nextInt();
			i++;
		}
		System.out.println(donations(arr,n));
	}
	
	static int donations(int[] arr, int n){
		int[] don1 = new int[n-1];
		int[] don2 = new int[n];
		don1[0] = arr[0];
		don1[1] = arr[1];
		don1[2] = arr[0]+arr[2];
		int max1 = donations(arr, n-2, don1, 1);
		don2[0] = 0;
		don2[1] = arr[1];
		don2[2] = arr[2];
		don2[3] = arr[1]+arr[3];
		int max2 = donations(arr, n-1, don2, 2);
		return Math.max(max1, max2);
	}

	static int donations(int[] arr, int n, int[] don, int turn){
		if(turn == 1){
			if(n<3)
				return don[n];
		}
		else{
			if(n<4)
				return don[n];
		}
		don[n] = Math.max(arr[n]+donations(arr,n-2,don,turn), arr[n-1]+donations(arr,n-3,don,turn));
		return don[n];
	}
}
