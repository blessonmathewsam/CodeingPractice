package Recursion;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
class Lotto { 

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int f = 0;
		while(true){
			int k;
			if(in.hasNext())
				k = in.nextInt();
			else
				break;
			if(k==0)
				break;
			int i = 0;
			int[] arr = new int[k];
			Boolean[] select = new Boolean[k];
			int[] ans = new int[6];
			while(i<k){
				if(in.hasNext())
					arr[i] = in.nextInt();
				else
					break;
				select[i] = false;
				i++;
			}
			if(f++>0) System.out.println();
			printLottos(0, 0, arr, select, ans);
		}
	}
	
	static void printLottos(int len, int pos, int[] arr, Boolean[] select, int[] ans){
		if(len == 6){
			for(int i=0; i<5; i++)
				System.out.print(ans[i]+" ");
			System.out.println(ans[5]);
			return;
		}
		for(int i=pos; i<arr.length; i++){
			if(!select[i]){
				select[i] = true;
				ans[len] = arr[i];
				printLottos(len+1, i+1, arr, select, ans);
				select[i] = false;
			}
		}
	}
}
	