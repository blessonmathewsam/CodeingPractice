/**
 * 
 */
package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blessonm
 *
 */
public class MaxProfitTwice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = new int[] {12, 11, 13, 9, 12, 8, 14, 13, 15};
		int minPrice = Integer.MAX_VALUE, max = 0;
		List<Integer> firstMax = new ArrayList<>();
		for (int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			max = Math.max(max, prices[i] - minPrice);
			firstMax.add(max);
		}
		max = 0;
		int maxPrice = Integer.MIN_VALUE;
		for (int i = prices.length-1; i > 0; i--) {
			maxPrice = Math.max(maxPrice, prices[i]);
			max = Math.max(max, (maxPrice - prices[i]) + firstMax.get(i-1));
		}
		System.out.println(max);
	}

}
