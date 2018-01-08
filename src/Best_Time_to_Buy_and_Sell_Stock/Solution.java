package Best_Time_to_Buy_and_Sell_Stock;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int maxProfit(int[] prices) {
        /**
         * Try to find the diff of left bottom and right top
         * 3ms
         */
        int max = 0;
        for (int i = 0, maxCur = 0; i < prices.length - 1; i++) {
            maxCur = Math.max(0, maxCur + prices[i + 1] - prices[i]); // profit of buy on i and sell on i + 1
            max = Math.max(max, maxCur); // accumulate these possible profits
        }
        return max;

    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        StdOut.println(s.maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
	}
}