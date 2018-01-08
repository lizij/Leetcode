package Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        /**
         * The problem asks us to sell the stock share before buy again.
         * Assuming our money is s, s0 is the money after sell, s1 is the money after buy.
         * s0: buy -> s1, nothing -> s0
         * s1: sell -> s0, nothing -> s1
         * Thus for each i, the formula is:
         * s0[i] = max(s0[i - 1], s1[i - 1] + prices[i] - fee)
         * s1[i] = max(s1[i - 1], s0[i - 1] - prices[i])
         * After n days, return s0[n - 1]
         * 23ms
         */
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] s = new int[2][n];
        s[0][0] = 0;
        s[1][0] = s[0][0] - prices[0];

        for (int i = 1; i < n; i++) {
            s[0][i] = Math.max(s[0][i - 1], s[1][i - 1] + prices[i] - fee);
            s[1][i] = Math.max(s[1][i - 1], s[0][i - 1] - prices[i]);
        }

        return Math.max(s[0][n - 1], s[1][n - 1]);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2)); // 8
	}
}