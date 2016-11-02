package Arrays;
import java.util.Scanner;

/**
 * Move  zeros to end of array
 */

/**
 * @author blessonm
 *
 */
public class MoveZeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while(i<n){
			arr[i] =in.nextInt();
			i++;
		}
		move(arr, n);
		for(i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void move(int[] arr, int n){
		int m = 0;
		for(int i=0, l=0; i<n; i++){
			if(arr[i]==0){
				int k = i;
				while(k<n){
					if(arr[k]==0){
						k++;
						m++;
					}
					else
						break;
				}
				while(k<n){
					if(arr[k]!=0){
						arr[l] = arr[k];
						l++;
						k++;
					}
					else
						break;
				}
				i = k-1;
			}
			else
				l++;
		}
		while(m>0){
			arr[n-1] = 0;
			n--;
			m--;
		}
	}
}
