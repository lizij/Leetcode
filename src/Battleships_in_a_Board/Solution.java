package Battleships_in_a_Board;



public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int N = board.length;
        int M = board[0].length;
        boolean[][] marked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!marked[i][j] && board[i][j] == 'X'){
                    int tmpi = i, tmpj = j;
                    while (tmpi < N && board[tmpi][j] == 'X') marked[tmpi++][j] = true;
                    while (tmpj < M && board[i][tmpj] == 'X') marked[i][tmpj++] = true;
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] input = {  {'X','.','.','X'},
                            {'.','.','.','X'},
                            {'.','.','.','X'}};
        System.out.println(s.countBattleships(input));
    }
}
