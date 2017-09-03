package Best_Time_to_Buy_and_Sell_Stock;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
//        for (int i = 0, min = Integer.MAX_VALUE; i < prices.length; i++) {
//            min = Math.min(min, prices[i]);
//            max = Math.max(max, prices[i] - min);
//        }
        for (int i = 0, maxCur = 0; i < prices.length - 1; i++) {
            max = Math.max(max, maxCur = Math.max(0, maxCur + prices[i + 1] - prices[i]));
        }
        return max;

    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
	}
}