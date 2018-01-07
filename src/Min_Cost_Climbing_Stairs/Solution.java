package Min_Cost_Climbing_Stairs;
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
//        return helper(cost, cost.length);
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    int helper(int[] cost, int pos) {
        if (pos == 0 || pos == 1) return 0;
        return Math.min(helper(cost, pos - 1) + cost[pos - 1], helper(cost, pos - 2) + cost[pos - 2]);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.minCostClimbingStairs(new int[]{10, 15, 20})); // 15
        System.out.println(s.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6
	}
}