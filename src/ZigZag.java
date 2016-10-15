import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class ZigZag {

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
		System.out.println(zigzag(arr,n));
	}
	
	static int zigzag(int[] arr, int n){
		int turn = 0;
		int[] len = new int[n];
		len[0] = 1;
		int max = 0;
		for(int i = 0; i < n-1; i++){
			if(turn == 0){
				if(arr[i]<arr[i+1])
					len[i+1] = len[i] + 1;
				else
					len[i+1] = 1;
				turn = 1;
			}
			else{
				if(arr[i]>arr[i+1])
					len[i+1] = len[i] + 1;
				else
					len[i+1] = 1;
				turn = 0;
			}
			if(len[i+1]>max)
				max = len[i+1];
		}
		return max;
	}

}
