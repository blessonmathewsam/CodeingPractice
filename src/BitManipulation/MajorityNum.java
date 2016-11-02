package BitManipulation;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class MajorityNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,1,2};
		int[] bits = new int[32];
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				bits[i] += ((nums[j]>>i) & 1)==1?1:0; 
			}
		}
		for (int i = 0; i < bits.length; i++) {
			if(bits[i]>nums.length/2){
				ret += 1<<i;
			}
		}
		System.out.println(ret);
	}

}
