package _2_Keys_Keyboard;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0){
                    dp[i] = Math.min(dp[j] + i / j, dp[i]);
                }
            }
        }
        return dp[n];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        StdOut.println(s.minSteps(3));
//        StdOut.println(s.minSteps(5));
//        StdOut.println(s.minSteps(6));
        StdOut.println(s.minSteps(9));
	}
}