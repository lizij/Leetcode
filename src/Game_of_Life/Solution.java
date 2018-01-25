package Game_of_Life;

import java.util.Arrays;

public class Solution {
    private int[][] board;
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        // link to board
        this.board = board;
        int m = board.length, n = board[0].length;

        /**
         * Brute force with copy: simulating Game of life rules
         * 2ms
         */

//        // copy board
//        int[][] clone = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            System.arraycopy(board[i], 0, clone[i], 0, n);
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int count = countNeighborLiveCells(clone, i, j);
//
//                if (clone[i][j] == 1 && (count < 2 || count > 3)) {
//                    // under-population or over-population
//                    board[i][j] = 0;
//                } else if (clone[i][j] == 0 && count == 3) {
//                    // reproduction
//                    board[i][j] = 1;
//                }
//            }
//        }

        /**
         * Brute force without copy
         * Use [2nd bit, 1st bit] to store next result in place, default 01 or 00
         * for board[i][j] as bit
         * 1. bit == 01:
         *      a. under-population or over-population: 01 -> 01
         *      b. 2 or 3 live neighbors: 01 -> 11
         * 2. bit == 00:
         *      a. 3 live neighbors: 00 -> 10
         *      b. others: 00 -> 00
         * 2ms
         */

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighborLiveCells(board, i, j);
                if ((board[i][j] & 1) == 1 && (count == 2 || count == 3)) {
                    board[i][j] = 3;
                } else if ((board[i][j] & 1) == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }

        // reset this.board
        this.board = null;
    }

    private int countNeighborLiveCells(int[][] board, int i, int j) {
        // get live neighbor cells
        if (!isValid(i, j)) {
            return 0;
        }
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int count = 0;
        for (int[] d: directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (isValid(x, y) && (board[x][y] & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		test(s, new int[][]{
                {0, 1, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        });
        // [[1,1,1,0],
        //  [1,0,0,1],
        //  [0,0,0,1],
        //  [1,1,1,1]]
        test(s, new int[][]{
                {1},{0},{0},{1},{0},{0},{1},{0},{0},{1}
        });
	}

	private static void test(Solution s, int[][] input) {
        s.gameOfLife(input);
        for (int[] row: input) {
            System.out.println(Arrays.toString(row));
        }
    }
}