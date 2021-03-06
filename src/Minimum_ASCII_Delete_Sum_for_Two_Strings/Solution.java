package Minimum_ASCII_Delete_Sum_for_Two_Strings;



public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
		/**
		 * dynamic programing
		 * s1: dp[0][0] to dp[s1.length][0], s2: dp[0][0] to dp[0][s2.length]
         * for every substring of s1[0-i]
         * for every substring of s2[0-j]
         * isSameParent the minimum delete sum and optimize the result
         * 45ms
		 */
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
		}
		for (int i = 1; i <= s2.length(); i++) {
			dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
			    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			        dp[i][j] = dp[i - 1][j - 1];
                }
                else {
			        dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
			}
		}
		return dp[s1.length()][s2.length()];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.minimumDeleteSum("sea", "eat"));//231
		System.out.println(s.minimumDeleteSum("delete", "leet"));//403
	}
}