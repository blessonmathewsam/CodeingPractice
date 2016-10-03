import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class MaxSumLimit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		int i = 0;
		int[] arr = new int[n];
		while(i<n){
			arr[i] = in.nextInt();
			i++;
		}
		
		int l = 0, r = 0;
		int sum = 0, num = 0, max = 0;		
		while(l<arr.length && r<arr.length){
			while(r<n && sum + arr[r] <= t){
				sum += arr[r];
				num++;
				r++;
			}
			max = Math.max(max, num);
			sum -= arr[l];
			num--;
			l++;
		}
		
		System.out.println(max);
	}

}
