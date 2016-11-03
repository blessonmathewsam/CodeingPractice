/**
 * 
 */
package Sorting;

/**
 * @author blessonm
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printOutput(sort(new int[] { 5, 4, 3, 2, 7, 6, 4 }));
	}

	public static int[] sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
		return arr;
	}

	public static void sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < L.length; i++) {
			L[i] = arr[l + i];
		}
		for (int i = 0; i < R.length; i++) {
			R[i] = arr[m + 1 + i];
		}
		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			k++;
			i++;
		}
		while (j < n2) {
			arr[k] = R[j];
			k++;
			j++;
		}
	}

	public static void printOutput(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}