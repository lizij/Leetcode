package Max_Increase_to_Keep_City_Skyline;
public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        /**
         * Straight solution: Compute the skyline and fill up the grid
         *
         */

        int m = grid.length, n = grid[0].length;
        int[] rowMax = new int[m];
        int[] colMax = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }

        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.maxIncreaseKeepingSkyline(new int[][]{
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}
        })); // 35
	}
}