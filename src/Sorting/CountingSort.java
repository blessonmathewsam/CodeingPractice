/**
 * 
 */
package Sorting;

import java.util.Arrays;

/**
 * @author blessonm
 *
 */
public class CountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printOutput(sort(new int[] {1, 4, 1, 2, 100, 5, 2}));
	}

	public static int[] sort(int[] arr){
		int[] output = new int[arr.length];
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] >max)
				max = arr[i];
		}
		int[] count = new int[(max-min)+2];
		
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		for (int i = 0; i < arr.length; i++) {
			++count[arr[i]];
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		for (int i = 0; i < arr.length; i++) {
			output[count[arr[i]]-1] = arr[i];
			--count[arr[i]];
		}
		return output;
	}
	
	public static void printOutput(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
