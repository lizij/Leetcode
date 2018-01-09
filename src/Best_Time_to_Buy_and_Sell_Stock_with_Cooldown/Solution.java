package Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int maxProfit(int[] prices) {
        /**
         * There are three states of money in total and three operations (buy, sell, rest)
         * for prices[i], assuming money is s, s will be s - prices[i] after buy or s + prices[i] after sell. rest means no buy or sell and no money in or out.
         * assume three states as s0, s1, s2 (in code they are s[i])
         * s0: buy->s1, rest->s0
         * s1: sell->s2, rest->s1
         * s2: rest->s0
         * Therefore, assuming s[i] is the maximum money after operate i:
         * s0[i] = max(s0[i - 1], s2[i - 1])
         * s1[i] = max(s0[i - 1] - prices[i], s1[i - 1])
         * s2[i] = s1[i - 1] + prices[i]
         * The question now is to isSameParent the maximum s0[i] or s2[i], since s1[i] is always lower than s0[i].
         * In other words, there can't be more profit after buy prices[i].
         * 18ms
         */
        if (prices == null || prices.length == 0) return 0;
        int[][] s = new int[3][prices.length];
        s[0][0] = 0;
        s[1][0] = s[0][0] - prices[0];
        s[2][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            s[0][i] = Math.max(s[0][i - 1], s[2][i - 1]);
            s[1][i] = Math.max(s[0][i - 1] - prices[i], s[1][i - 1]);
            s[2][i] = s[1][i - 1] + prices[i];
        }
        return Math.max(s[0][prices.length - 1], s[2][prices.length - 1]);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.maxProfit(new int[]{1, 2, 3, 0, 2}));
	}
}