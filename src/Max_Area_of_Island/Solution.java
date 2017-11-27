package Max_Area_of_Island;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
	int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
		/**
		 * standard depth first search in graph
		 * 38ms
		 */
		if (grid.length == 0 || grid[0].length == 0) return 0;
       	this.grid = grid;
       	int m = grid.length, n = grid[0].length;
       	boolean[][] marked = new boolean[m][n];
       	int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
       	int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !marked[i][j]) {
					int area = dfs(i, j, marked, direction);
					res = Math.max(res, area);
				}
			}
		}
		return res;
	}

    private int dfs(int row, int col, boolean[][] marked, int[][] direction) {
    	marked[row][col] = true;
    	int res = 1;
		for (int[] d: direction) {
			int x = row + d[0];
			int y = col + d[1];
			if (isValid(x, y) && !marked[x][y] && grid[x][y] == 1) {
				res += dfs(x, y, marked, direction);
			}
		}
		return res;
	}

	private boolean isValid(int x, int y) {
    	return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		StdOut.println(s.maxAreaOfIsland(new int[][]{
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}
		}));
	}
}