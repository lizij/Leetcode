package Knight_Probability_in_Chessboard;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        /**
         * Converse thinking: Start from every point on board, see if knight can move to (r, c) after K moves
         * 25ms
         */
        double[][] dp = new double[N][N];
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, 2}, {1, -2}, {2, -1}, {2, 1}};
        for(double[] row: dp) Arrays.fill(row, 1);
        for (int k = 0; k < K; k++){
            double[][] tmp = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] m: moves) {
                        if (isValid(i + m[0], j + m[1], N)) tmp[i][j] += dp[i + m[0]][j + m[1]];
                    }
                }
            }
            dp = tmp;
        }
        return dp[r][c] / Math.pow(8, K);

        /**
         * Positive thinking with more space for calculating
         * 10ms
         */
//        return move(K, r, c, N, new double[N][N][K + 1]) / Math.pow(8, K);
    }

     private double move(int moves, int x, int y, int N, double[][][] memo) {
         if (!isValid(x, y, N)) return 0;
         if (moves == 0) return 1;
         if (memo[x][y][moves] > 0) return memo[x][y][moves];
         memo[x][y][moves] = move(moves - 1, x - 2, y - 1, N, memo)
                    + move(moves - 1, x - 2, y + 1, N, memo)
                    + move(moves - 1, x - 1, y - 2, N, memo)
                    + move(moves - 1, x - 1, y + 2, N, memo)
                    + move(moves - 1, x + 1, y - 2, N, memo)
                    + move(moves - 1, x + 1, y + 2, N, memo)
                    + move(moves - 1, x + 2, y - 1, N, memo)
                    + move(moves - 1, x + 2, y + 1, N, memo);
         return memo[x][y][moves];
     }

    private boolean isValid(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.knightProbability(3,2,0,0));//0.0625
        System.out.println(s.knightProbability(8,30,6,4));//0.00019
	}
}