package Arrays;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class MaximumFactor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int i = 0;
		int[][] arr = new int[n][2];
		while(i<n){
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
			i++;
		}
		in.close();
		Arrays.sort(arr, new java.util.Comparator<int[]>(){
			public int compare(int[] a, int[]b){
				 return Integer.compare(a[0], b[0]);
			}
		});
		int l = 0, r = 0;
		long sum = 0, res = 0;
		while(l<arr.length){
			int diff = Math.abs(arr[l][0]-arr[r][0]);
			while(diff>=d){
				sum -= arr[r][1];
				r++;
				diff = Math.abs(arr[l][0]-arr[r][0]);			
			}
			sum += arr[l][1];
			l++;
			res = Math.max(sum, res);
		}
		System.out.println(res);

	}

}
