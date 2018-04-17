package Zuma_Game;



public class Solution {
    public int findMinStep(String board, String hand) {
        /**
         * Use Depth-First Search to calculate the final min steps.
         * clear() is to every more than 2 consecutive balls
         * In calculate(), there is only 1 or 2 consecutive balls, so try to clear them one group after another.
         * If there are enough balls, clear these balls as a group and calculate others as a new board.
         *
         */
        int[] balls = new int[26];
        for (int i = 0; i < hand.length(); i++) {
            balls[hand.charAt(i) - 'A']++;
        }
        int res = calculate(board, balls);
        return res == 6 ? -1 : res;
    }

    private int calculate(String board, int[] balls) {
        board = clear(board);
        if (board.equals("")) return 0;
        int res = 6;
        for (int i = 0, j; i < board.length(); i++) {
            char c = board.charAt(i);
            for (j = i; j < board.length() && board.charAt(j) == c; j++);
            int need = 3 - (j - i);
            if (balls[c - 'A'] >= need) {
                balls[c - 'A'] -= need;
                res = Math.min(res, need + calculate(board.substring(0, i) + board.substring(j), balls));
                balls[c - 'A'] += need;
            }
            i = j - 1;
        }
        return res;
    }

    private String clear(String row) {
        for (int i = 0, j; i < row.length(); i++) {
            for (j = i; j < row.length() && row.charAt(j) == row.charAt(i); j++) ;
            if (j - i >= 3) return clear(row.substring(0, i) + row.substring(j));
            else i = j - 1;
        }
        return row;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.findMinStep("WRRBBW", "RB"));//-1
        System.out.println(s.findMinStep("WWRRBBWW", "WRBRW"));//2
        System.out.println(s.findMinStep("G", "GGGGG"));//2
        System.out.println(s.findMinStep("RBYYBBRRB", "YRBGB"));//3
        System.out.println(s.findMinStep("RRWWRRW", "WWRRR"));//2
        System.out.println(s.findMinStep("WRYYRWWRRWW", "WYBR"));//2
	}
}