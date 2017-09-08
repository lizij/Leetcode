package Diagonal_Traverse;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    private int M, N;
    private int[][] matrix;
    private boolean[][] marked;
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[]{};
        M = matrix.length;
        N= matrix[0].length;
        int[] res = new int[M * N];

        /** use boolean marked array and up to memorize the direction and the values visited
         *  487ms
         */
//        this.matrix = matrix;
//        marked = new boolean[M][N];
//        boolean up = true;
//        int pos = 0;
//        for (int i = 0; i < M + N; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (up) {
//                    pos = addToResult(i - j, j, res, pos);
//                }
//                else{
//                    pos = addToResult(j, i - j, res, pos);
//                }
//            }
//            up = !up;
//        }

        /** use direction array to control the visited matrix value directly
         *  10ms
         */
        int row = 0, col = 0, d = 0;
        int[][] direction = {{-1, 1}, {1, -1}};
        for (int i = 0; i < M * N; i++) {
            res[i] = matrix[row][col];
            row += direction[d][0];
            col += direction[d][1];

            if (row > M - 1){row = M - 1;col += 2;d = 1 - d;}//break bottom border
            if (col > N - 1){row += 2;col = N - 1;d = 1 - d;}//break right border
            if (row < 0) {row = 0;d = 1 - d;}//break top border
            if (col < 0){col = 0;d = 1 - d;}//break left border

        }
        return res;
    }

    private boolean isValid(int x, int y){
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    private int addToResult(int x, int y, int[] res, int pos){
        if (!isValid(x, y) || marked[x][y]) return pos;
        res[pos] = matrix[x][y];
        marked[x][y] = true;
        return pos + 1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[][] input1 = new int[][]{
//                {1,  2,  3,  4},
//                {5,  6,  7,  8},
//                {9, 10, 11, 12}
//        };
//		for (int i: s.findDiagonalOrder(input1)){
//            StdOut.print(i + " ");
//        }
        int[][] input2 = new int[][]{
                {1,  2,  3},
                {5,  6,  7},
                {9, 10, 11}
        };
        for (int i: s.findDiagonalOrder(input2)){
            StdOut.print(i + " ");
        }
	}
}