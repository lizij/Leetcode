package Best_Time_to_Buy_and_Sell_Stock_II;
public class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1;total += prices[i + 1] > prices[i] ? prices[i + 1] - prices[i] : 0, i++);
        return total;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}