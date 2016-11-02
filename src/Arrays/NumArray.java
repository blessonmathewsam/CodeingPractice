package Arrays;
/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class NumArray {

	/**
	 * @param args
	 */
	int[] nums;
	int[] sums;
	
	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] {1,2,3,4,5});
		System.out.println(numArray.sumRange(0, 0));		 
	}
    
	public NumArray(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        fillSums();
    }
    
    public int fillSums(){
        if(this.nums.length==0) return 0;
        this.sums[0] = this.nums[0];
        for(int i=1; i<this.nums.length; i++){
            this.sums[i] = this.nums[i]+this.sums[i-1];
        }
        return 0;
    }

    public int sumRange(int i, int j) {
        if(i==0) return this.sums[j];
        return this.sums[j]-this.sums[i-1];
    }
}
