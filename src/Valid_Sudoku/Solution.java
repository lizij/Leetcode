package Valid_Sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        /**
         * Coding solution
         * n in row r: "r(n)"
         * n in row c: "(n)c"
         * n in top-right block: "0(n)2"
         * 36ms
         */
        Set<String> set = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                String n = "(" + board[r][c] + ")";
                String row = r + n;
                String col = n + c;
                String block = r / 3 + n + c / 3;
                if (set.contains(row) || set.contains(col) || set.contains(block)) {
                    return false;
                }
                set.add(row);
                set.add(col);
                set.add(block);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValidSudoku(new char[][]{
                {'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'}
        })); // true
    }
}