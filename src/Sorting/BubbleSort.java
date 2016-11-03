/**
 * 
 */
package Sorting;

/**
 * @author blessonm
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		printOutput(sort(new int[] {5,4,3,2,7,6,4}));
	}
	
	public static int[] sort(int[] arr){
		Boolean swapped = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]){
					int temp = 0;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped)
				break;
		}
		return arr;
	}
	
	public static void printOutput(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
