package Best_Time_to_Buy_and_Sell_Stock_IV;
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        /**
         * DP solution
         * maxProfits[kk, i]: the max profit up until prices[i] (NOT ending with prices[i]) using at most k transactions
         * maxProfits[kk, i] = max(maxProfits[kk, i - 1], prices[i] - prices[j] + maxProfits[kk - 1, j]), j in range of [0, i - 1]
         *                  = max(maxProfits[kk, i - 1], prices[i] + max(maxProfits[kk - 1, j] - prices[j])), j in range of [0, i - 1]
         * maxProfits[0, i] = 0: no transaction makes 0 profit
         * maxProfits[kk, 0] = 0: no prices makes 0 profit
         * To prevent memory-limit-exceeded, use currentMaxProfits for maxProfits[kk, i], lastMaxProfits for maxProfits[kk - 1, i]
         * 8ms
         */

        if (k >= prices.length / 2) {
            // k >= prices.length means we don't have to make as many as k transactions
            return quickSolve(prices);
        }
        int res = 0;
        int[] currentMaxProfits = new int[prices.length];
        int[] lastMaxProfits = new int[prices.length];
        // start from 1 as maxProfits[0, i] == 0
        for (int kk = 1; kk <= k; kk++) {
            // start from 1 as maxProfits[kk, 0] == 0
            int tmpMax = lastMaxProfits[0] - prices[0]; // max(maxProfits[kk - 1, j] - prices[j])
            for (int i = 1; i < prices.length; i++) {
                currentMaxProfits[i] = Math.max(currentMaxProfits[i - 1], prices[i] + tmpMax);
                tmpMax = Math.max(tmpMax, lastMaxProfits[i] - prices[i]);
                res = Math.max(res, currentMaxProfits[i]);
            }

            int[] tmp = currentMaxProfits;
            currentMaxProfits = lastMaxProfits;
            lastMaxProfits = tmp;
        }
        return res;
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }


    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.maxProfit(1, new int[]{1, 3, 2, 8, 4, 9})); // 8
		System.out.println(s.maxProfit(2, new int[]{1, 3, 2, 8, 4, 9})); // 12
		System.out.println(s.maxProfit(3, new int[]{1, 3, 2, 8, 4, 9})); // 13
	}
}