package DivideAndConquer;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		System.out.println("Enter the count: ");
		count = scanner.nextInt();
		int[] array = new int[count];
		System.out.println("Enter the numbers in order: ");
		for (int i = 0; i < count; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Enter number to search: ");
		int num = scanner.nextInt();
		scanner.close();
		System.out.print("The number is at index "+binarySearch(num, array));
	}
	
	public static int binarySearch(int num, int[] array){
		int low = 0;
		int high = array.length - 1;
		
		while(high >= low){
			int mid = (high + low)/2;
			if(array[mid] == num)
				return mid;
			else if(array[mid] < num)
				low = mid + 1;
			else
				high = mid - 1;
		}
		
		return -1;
	}

}
