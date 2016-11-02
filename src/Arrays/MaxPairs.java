package Arrays;
/**
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author blessonm
 *
 */

public class MaxPairs{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] bArray = new int[n];
        int i = 0;
        while(i<n){
            bArray[i] = in.nextInt();
            i++;
        }
        n = in.nextInt();
        int[] gArray = new int[n];
        i = 0;
        while(i<n){
            gArray[i] = in.nextInt();
            i++;
        }
        Arrays.sort(bArray);
        Arrays.sort(gArray);
        int l = 0, r = 0;
        int pairs = 0;
        while(l<bArray.length && r<gArray.length){
        	if(Math.abs(bArray[l]-gArray[r]) <= 1){
        		pairs++;
        		l++;
        		r++;
        	}
        	else if(bArray[l]<gArray[r]){
        		l++;
        	}
        	else{
        		r++;
        	}
        }
        System.out.println(pairs);
    }
}