package Recursion;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class PascalsTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int[] previousRow = {1};
		System.out.println(1);
		int row = 2;
		while(row<=rows){
			int[] currentRow = new int[previousRow.length+1];
			currentRow[0] = 1;
			currentRow[currentRow.length-1] = 1;
			for(int i=0; i<=row-3; i++){
				currentRow[i+1] = previousRow[i]+previousRow[i+1]; 
			}
			previousRow=currentRow;
			for(int i=0; i<previousRow.length; i++){
				System.out.print(previousRow[i]+" ");
			}
			System.out.println();
			row++;
		}
	}

}
