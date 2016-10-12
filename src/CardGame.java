import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class CardGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i = 0;
		int[] arr = new int[n];
		while(i<n){
			arr[i] = in.nextInt();
			i++;
		}
		int l = 0, r = arr.length-1;
		int sum1 = 0, sum2 = 0;
		Boolean flag = false;
		while(l<=r){
			if(!flag){
				if(arr[l]>arr[r]){
					sum1 += arr[l];
					l++;
				}
				else{
					sum1 += arr[r];
					r--;
				}
				flag = true;
			}
			else{
				if(arr[l]>arr[r]){
					sum2 += arr[l];
					l++;
				}
				else{
					sum2 += arr[r];
					r--;
				}
				flag = false;
			}
		}
		System.out.print(sum1+" "+sum2);
	}
}
