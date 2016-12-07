/**
 * 
 */
package Arrays;

/**
 * @author blessonm
 *
 */
public class MaxProfitStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = new int[] {300, 320, 310, 330, 315, 320, 350, 340};
		int max = 0, minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}
		System.out.println(max);
	}

}
