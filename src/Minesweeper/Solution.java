package Minesweeper;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    private int N;
    private int M;
    private char[][] board;
    public char[][] updateBoard(char[][] board, int[] click) {
        if (click.length != 2) return board;
        this.board = board;
        N = board.length;
        M = board[0].length;
        click(click[0], click[1]);
        return board;
    }

    private void click(int x, int y){
        if (!isValid(x, y)) return;
        char pointValue = board[x][y];
        if (pointValue == 'M'){
            board[x][y] = 'X';
        }
        else if (pointValue == 'E'){
            int minesAdjacent = countMines(x, y);
            if (minesAdjacent != 0){
                board[x][y] = (char)(minesAdjacent + 48);
            }
            else{
                board[x][y] = 'B';
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        click(x + i, y + j);
                    }
                }
            }
        }
    }

    private int countMines(int x, int y){//count unrevealed mines adjacent to a square
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if(isMine(x + i, y + j)) count++;
            }
        }
        return count;
    }

    private boolean isMine(int x, int y){
        if (isValid(x, y) && board[x][y] == 'M') return true;
        return false;
    }

    private boolean isValid(int x, int y){
        if (x < 0 || x >= N) return false;
        if (y < 0 || y >= M) return false;
        return true;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		char[][] board1 = {
		        {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
		};
        char[][] output1 = s.updateBoard(board1, new int[]{3, 0});
        for (int i = 0; i < output1.length; i++) {
            for (int j = 0; j < output1[0].length; j++) {
                StdOut.print(output1[i][j] + " ");
            }
            StdOut.println();
        }
        StdOut.println();
        StdOut.println(s.countMines(1, 1));

        char[][] board2 = {
		        {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
		};
        char[][] output2 = s.updateBoard(board2, new int[]{1, 2});
        for (int i = 0; i < output2.length; i++) {
            for (int j = 0; j < output2[0].length; j++) {
                StdOut.print(output2[i][j] + " ");
            }
            StdOut.println();
        }
        StdOut.println();
	}
}