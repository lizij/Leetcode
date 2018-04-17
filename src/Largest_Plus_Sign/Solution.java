package Largest_Plus_Sign;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (N <= 0) {
            return 0;
        }

        /**
         * Brute force solution: from every node to extend
         * 744ms
         */

//        int[][] grid = new int[N][N];
//        for (int[] r: grid) {
//            Arrays.fill(r, 1);
//        }
//
//        for (int[] m: mines) {
//            grid[m[0]][m[1]] = 0;
//        }
//
//        int res = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (grid[i][j] == 1) {
//                    int k = extend(grid, i, j);
//                    res = Math.max(res, k);
//                }
//            }
//        }
//        return res;

        /**
         * DP solution: from every
         * 129ms
         */
        int[][] dp = new int[N][N];

        for (int[] r: dp) {
            Arrays.fill(r, 1);
        }

        for (int[] m: mines) {
            dp[m[0]][m[1]] = 0;
        }

        int res = 0, count;

        for (int r = 0; r < N; ++r) {
            count = 0;
            for (int c = 0; c < N; ++c) {
                count = dp[r][c] == 0 ? 0 : count + 1;
                dp[r][c] = count;
            }

            count = 0;
            for (int c = N-1; c >= 0; --c) {
                count = dp[r][c] == 0 ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for (int c = 0; c < N; ++c) {
            count = 0;
            for (int r = 0; r < N; ++r) {
                count = dp[r][c] == 0 ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }

            count = 0;
            for (int r = N-1; r >= 0; --r) {
                count = dp[r][c] == 0 ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                res = Math.max(res, dp[r][c]);
            }
        }

        return res;
    }

    private int extend(int[][] grid, int r, int c) {
        int k = 1;
        while (isValid(grid, r + k, c) && grid[r + k][c] == 1
                && isValid(grid, r - k, c) && grid[r - k][c] == 1
                && isValid(grid, r, c + k) && grid[r][c + k] == 1
                && isValid(grid, r, c - k) && grid[r][c - k] == 1) {
            k++;
        }
        return k;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.orderOfLargestPlusSign(5, new int[][]{{4, 2}})); // 2
		System.out.println(s.orderOfLargestPlusSign(2, new int[][]{})); // 1
		System.out.println(s.orderOfLargestPlusSign(1, new int[][]{{0, 0}})); // 0
	}
}