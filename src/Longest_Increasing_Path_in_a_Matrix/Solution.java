package Longest_Increasing_Path_in_a_Matrix;

import java.util.*;

public class Solution {
    private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        /**
         * DFS solution with cache
         * From every cell [i, j] to find a increasing path,
         * with a cache[i][j] to memorize previous result
         * 16ms
         */

        int res = 1;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j, cache));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (!isValid(matrix, i, j)) {
            return 0;
        }

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        cache[i][j] = 1;
        for (int[] d: direction) {
            int x = i + d[0];
            int y = j + d[1];
            if (isValid(matrix, x, y) && matrix[x][y] > matrix[i][j]) {
                int count = dfs(matrix, x, y, cache) + 1;
                cache[i][j] = Math.max(cache[i][j], count);
            }
        }
        return cache[i][j];
    }

    private boolean isValid(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        })); // 4
        System.out.println(s.longestIncreasingPath(new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        })); // 4
	}
}