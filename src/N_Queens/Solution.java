package N_Queens;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<String>> res;
    private int N;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n == 0) return res;
        N = n;
        placeQueens(0, null, null);
        return res;
    }

    private void placeQueens(int row, List<Integer> list, boolean[][] marked){
        if (row == 0){
            list = new ArrayList<>();
            marked = new boolean[N][N];
        }

        if (row == N){
            List<String> board = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < N; j++)
                    if (j == list.get(i)) builder.append('Q');
                    else builder.append('.');
                board.add(builder.toString());
            }
            res.add(board);
            return;
        }

        for (Integer col = 0; col < N; col++) {
            if (marked[row][col]) continue;
            list.add(col);
            boolean[][] newMarked = copy(marked);
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (i == row || j == col || i + j == row + col || i - j == row - col) newMarked[i][j] = true;
            placeQueens(row + 1, list, newMarked);
            list.remove(col);
        }
    }

    private boolean[][] copy(boolean[][] a){
        boolean[][] b = new boolean[N][N];
        for (int i = 0; i < N; i++) System.arraycopy(a[i], 0, b[i], 0, N);
        return b;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<String>> output1 = s.solveNQueens(4);
        for (int i = 0; i < output1.size(); i++) {
            StdOut.println("==============");
            List<String> list = output1.get(i);
            for (int j = 0; j < list.size(); j++) StdOut.println(list.get(j));
            StdOut.println("==============");
        }
    }
}