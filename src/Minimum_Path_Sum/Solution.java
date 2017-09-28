package Minimum_Path_Sum;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int minPathSum(int[][] grid) {
        /**
         * dynamic programming solution
         * 2ms
         */
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        return generate(grid, m - 1, n - 1, memo);
    }

    private int generate(int[][] grid, int m, int n, int[][] memo) {
        if (memo[m][n] > 0) return memo[m][n];
        if (m == 0 || n == 0) {
            int sum = 0;
            for (int i = 0; i <= Math.max(m, n); i++) {
                if (m == 0) sum += grid[0][i];
                else sum += grid[i][0];
            }
            return sum;
        }
        memo[m][n] = Math.min(generate(grid, m - 1, n, memo), generate(grid, m, n - 1, memo)) + grid[m][n];
        return memo[m][n];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.minPathSum(new int[][]{
                { 1,10,11,12},
                { 2, 3, 4, 5},
                { 9, 8, 7, 6}
        }));
	}
}