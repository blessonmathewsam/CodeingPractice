package Heaps;
/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class FindKthLarge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {3,2,5,4,6,9,12};
		int k = 3;
		int n = nums.length;
		FindKthLarge f = new FindKthLarge();
        for(int i=n/2-1; i>=0; i--){
            f.heapify(nums, n, i);
        }
        //printArray(nums);
        for(int i=n-1; i>=0; i--){
            if(i==n-k)
                System.out.print(nums[0]);
            f.getMax(nums, i);  
        }
	}
	
	public void heapify(int[] nums, int n, int i){
        int max = i;
        int l = 2*i+1;
        int r = 2*i+2;
        
        if(l<n && nums[l]>nums[max])
            max = l;
        if(r<n && nums[r]>nums[max])
            max = r;
        if(max!=i){
            int temp = nums[max];
            nums[max] = nums[i];
            nums[i] = temp;
            heapify(nums, n, max);
        }
    }
    
    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    public int getMax(int[] nums, int n){
        int temp = nums[0];
        nums[0] = nums[n];
        nums[n] = temp;
        heapify(nums, n, 0);
        return temp;
    }
}
