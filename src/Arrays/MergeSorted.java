package Arrays;
/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class MergeSorted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {1,3,4,6,8,10,0,0,0,0,0,0,0,0};
		int[] nums2 = {2,5,7,9};
		int m = 6, n = 4;
		int i=m-1, k=n-1;
        while(i>=0) {
            while(k>=0){
                if(nums2[k]>=nums1[i]){
                    nums1[i+k+1] = nums2[k];
                    k--;
                }
                else
                    break;
            }
            if(k>=0)
                nums1[i+k+1] = nums1[i];
            i--;
        }
        while(k>=0){
            nums1[k] = nums2[k];
            k--;
        }
        for (int j = 0; j < nums1.length; j++) {
			System.out.print(nums1[j]+" ");
		}	
	}

}
