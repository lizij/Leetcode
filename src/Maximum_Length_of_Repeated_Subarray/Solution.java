package Maximum_Length_of_Repeated_Subarray;
public class Solution {
    public int findLength(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }

        /**
         * DP solution
         * dp[i][j]: the longest common prefix of A[i...] and B[j...]
         * if A[i] == B[j], dp[i][j] = dp[i + 1][j + 1] + 1
         * else dp[i][j] = 0
         * The answer is max(dp[i][j]) over all (i, j)
         * 86ms
         */

        int[][] dp = new int[A.length + 1][B.length + 1];
        int res = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    private int findLength(int[] A, int[] B, int i, int j) {

        if (A == null || B == null || i >= A.length || j >= B.length) {
            return 0;
        }
        if (A[i] == B[j]) {
            return 1 + findLength(A, B, i + 1, j + 1);
        }
        return Math.max(findLength(A, B, i + 1, j), findLength(A, B, i, j + 1));
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7})); // 3
	}
}