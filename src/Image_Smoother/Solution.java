package Image_Smoother;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    private int n;
    private int m;
    public int[][] imageSmoother(int[][] M) {
        n = M.length;
        m = M[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                smooth(M, res, i, j);
            }
        }
        return res;
    }

    private void smooth(int[][] M, int[][] res, int x, int y){
        int count = 0, sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!isValid(x + i, y + j)) continue;
                sum += M[x + i][y + j];
                count++;
            }
        }
        res[x][y] = sum / count;
    }

    private boolean isValid(int x, int y){
        if (x < 0 || x >= n) return false;
        if (y < 0 || y >= m) return false;
        return true;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] input1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
		int[][] output1 = s.imageSmoother(input1);
        for (int i = 0; i < output1.length; i++) {
            for (int j = 0; j < output1[0].length; j++) StdOut.print(output1[i][j] + " ");
            StdOut.println();
        }
    }
}