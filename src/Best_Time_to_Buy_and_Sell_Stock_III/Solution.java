package Best_Time_to_Buy_and_Sell_Stock_III;
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        /**
         * Brute force: divide prices into 2 parts and compute each max profit of one part. Then compare their sum with cached max profit
         * Time limit exceeded
         */
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            int profit = maxProfitOneTime(prices, 0, i - 1) + maxProfitOneTime(prices, i, prices.length - 1);
//            if (profit > maxProfit) {
//                maxProfit = profit;
//            }
//        }
//        return maxProfit;

        /**
         * DP solution
         * maxProfits[kk, i]: the max profit up until prices[i] (NOT ending with prices[i]) using at most k transactions
         * maxProfits[kk, i] = max(maxProfits[kk, i - 1], prices[i] - prices[j] + maxProfits[kk - 1, j]), j in range of [0, i - 1]
         *                  = max(maxProfits[kk, i - 1], prices[i] + max(maxProfits[kk - 1, j] - prices[j])), j in range of [0, i - 1]
         * maxProfits[0, i] = 0: no transaction makes 0 profit
         * maxProfits[kk, 0] = 0: no prices makes 0 profit
         * 4ms
         */
        int k = 2; // most number of transactions
        int res = 0;
        int[][] maxProfits = new int[k + 1][prices.length];
        // start from 1 as maxProfits[0, i] == 0
        for (int kk = 1; kk <= k; kk++) {
            // start from 1 as maxProfits[kk, 0] == 0
            int tmpMax = maxProfits[kk - 1][0] - prices[0]; // max(maxProfits[kk - 1, j] - prices[j])
            for (int i = 1; i < prices.length; i++) {
                maxProfits[kk][i] = Math.max(maxProfits[kk][i - 1], prices[i] + tmpMax);
                tmpMax = Math.max(tmpMax, maxProfits[kk - 1][i] - prices[i]);
                res = Math.max(res, maxProfits[kk][i]);
            }
        }
        return res;
    }

    private int maxProfitOneTime(int[] prices, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = lo; i <= hi; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.maxProfit(new int[]{1, 3, 2, 8, 4, 9})); // 12
	}
}