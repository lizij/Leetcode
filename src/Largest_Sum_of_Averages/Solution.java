package Largest_Sum_of_Averages;

public class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        if (A == null || A.length == 0 || K <= 0 || K > A.length) {
            return 0;
        }

        /**
         * DP solution
         * dp[i][k] is the best score partitioning A[i:] into at most k parts
         * average(i, j) = (A[i] + ... + A[j - 1]) / (j - i) = (sum[0:j] - sum[0:i]) / (j - i)
         * dp[i][k] = max(average(i, N), max{average(i, j) + dp[j][k - 1], 0 <= i < j < N})
         * Because dp[][k] depends on dp[][k - 1], so we can optimize the extra space by calculating from 0 to K
         * 18ms
         */

        int n = A.length;
        double[] sum = new double[n + 1]; // sum[i + 1] is the sum of A[0...i]
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + A[i];
        }

        double[] dp = new double[n];
        for (int i = 0; i < n; i++) {
            // dp[i] = sum[i...(n - 1)] / (n - i)
            dp[i] = (sum[n] - sum[i]) / (n - i);
        }

        for (int k = 0; k < K - 1; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    dp[i] = Math.max(dp[i], (sum[j] - sum[i]) / (j - i) + dp[j]);
                }
            }
        }

        return dp[0];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.largestSumOfAverages(new int[]{9,1,2,3,9}, 3)); // 20
		System.out.println(s.largestSumOfAverages(new int[]{4,1,7,5,6,2,3}, 4)); // 20
	}
}