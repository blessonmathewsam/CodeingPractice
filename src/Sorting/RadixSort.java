/**
 * 
 */
package Sorting;

/**
 * @author blessonm
 *
 */
public class RadixSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printOutput(sort(new int[] {5,4,3,2,7,6,4}));
	}

	public static int[] sort(int[] arr){
		int max = findMax(arr);
		for (int exp = 1; max/exp > 0; exp *= 10) {
			countingSort(arr, exp);
		}
		return arr;
	}
	
	public static int findMax(int[] arr){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(max < arr[i])
				max = arr[i];
		}
		return max;
	}
	
	public static void countingSort(int[] arr, int exp){
		int[] output = new int[arr.length]; 
		int[] count = new int[10];
		for (int i = 0; i < arr.length; i++) {
			count[(arr[i]/exp)%10]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		for (int i = 0; i < arr.length; i++) {
			output[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i < output.length; i++) {
			arr[i] = output[i];
		}
	}
	
	public static void printOutput(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
