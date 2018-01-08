package Best_Time_to_Buy_and_Sell_Stock_II;
public class Solution {
    public int maxProfit(int[] prices) {
        /**
         * Instead of looking for every peak following a valley,
         * we can simply go on crawling over the slope and keep on adding the profit obtained from every consecutive transaction.
         * In the end, we will be using the peaks and valleys effectively,
         * but we need not track the costs corresponding to the peaks and valleys along with the maximum profit,
         * but we can directly keep on adding the difference between the consecutive numbers of the array if the second number is larger than the first one,
         * and at the total sum we obtain will be the maximum profit.
         * 2ms
         */
        int total = 0;
        for (int i = 0; i < prices.length - 1;i++) {
            total += prices[i + 1] > prices[i] ? prices[i + 1] - prices[i] : 0;
        }
        return total;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}