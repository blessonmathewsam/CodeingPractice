package Arrays;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Find number of elements less than or equal to each element in second array present in first array.
 */

/**
 * @author blessonm
 *
 */
public class LessOrEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		Integer[] a = new Integer[n1];
		int[] b = new int[n2];
		int i = 0;
		while(i<n1){
			a[i] = in.nextInt();
			i++;
		}
		if(a.length>1)
			Arrays.sort(a);
		i = 0;
		while(i<n2){
			b[i] = in.nextInt();
			i++;
		}
		i = 0;
		while(i<n2){
			if(a.length==1){
				if(a[0]<=b[i])
					System.out.print(1+ " ");
				else
					System.out.print(0+ " ");
			}
			else
				System.out.print(search(a, b[i])+ " ");
			i++;
		}
	}
	
	public static int search(Integer[] a, int n){
		int low = 0, high = a.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(mid==a.length-1)
				return a.length;
			if(a[mid]<=n && a[mid+1]>n){
				return mid+1;
			}
			else if(a[mid] <= n)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return 0;
	}
}
