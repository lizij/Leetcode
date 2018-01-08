package Flood_Fill;

import Others.Utils;

public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        /**
         * Use visited and DFS to fill color
         * 26ms
         */
        if (image == null || image.length == 0 || image[0].length == 0) return image;
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        fill(image, sr, sc, newColor, visited, direction);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int newColor, boolean[][] visited, int[][] direction) {
        if (!isValid(sr, sc, image) || visited[sr][sc]) {
            return;
        }
        visited[sr][sc] = true;
        for (int[] d: direction) {
            int x = sr + d[0];
            int y = sc + d[1];
            if (isValid(x, y, image) && image[sr][sc] == image[x][y]) {
                fill(image, x, y, newColor, visited, direction);
            }
        }
        image[sr][sc] = newColor;
    }

    private boolean isValid(int x, int y, int[][] image) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] output = s.floodFill(new int[][]{
		                {1, 1, 0},
                        {1, 1, 0},
                        {1, 0, 1}
                        }, 1, 1, 2);
        Utils.printMatrix(output);// [[2,2,2],[2,2,0],[2,0,1]]
	}
}