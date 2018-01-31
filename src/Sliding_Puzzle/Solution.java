package Sliding_Puzzle;

import java.util.*;

public class Solution {

    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return -1;
        }

        /**
         * BFS solution
         * First of all, map board to an char array for swap
         * In each round, add all possible states varied from the last round into queue
         * and check if there is a target
         * 18ms
         */
        int[] move = new int[]{-1, 1, -3, 3}; // possible index movement

        String target = "123450"; // target state
        String begin = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", "");; // begin state

        Queue<String> queue = new LinkedList<>(); // for BFS
        queue.offer(begin);

        Set<String> visited = new HashSet<>(); // visited
        visited.add(begin);

        int res = 0; // count breadth

        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                String cur = queue.poll(); // current state

                if (cur.equals(target)) {
                    // reach target
                    return res;
                }

                int zeroIndex = cur.indexOf('0'); // get 0 index

                for (int m : move) {
                    String newState = swap(cur, zeroIndex, zeroIndex + m); // new state after swap
                    if (newState != null && !visited.contains(newState)) {
                        visited.add(newState);
                        queue.offer(newState);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        if (i < 0 || i > 5 || j < 0 || j > 5 || i == 2 && j == 3 || i == 3 && j == 2) {
            return null;
        }
        char[] chs = s.toCharArray();
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
        return String.valueOf(chs);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(s.slidingPuzzle(new int[][]{
//                {1, 2, 3},
//                {4, 0, 5}
//        })); // 1
//        System.out.println(s.slidingPuzzle(new int[][]{
//                {1, 2, 3},
//                {5, 4, 0}
//        })); // -1
//        System.out.println(s.slidingPuzzle(new int[][]{
//                {4, 1, 2},
//                {5, 0, 3}
//        })); // 5
        System.out.println(s.slidingPuzzle(new int[][]{
                {3, 2, 4},
                {1, 5, 0}
        })); // 14
	}
}