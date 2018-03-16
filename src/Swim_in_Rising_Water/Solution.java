package Swim_in_Rising_Water;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length != grid[0].length) {
            return 0;
        }

        /**
         * Greedy solution
         * In every step, choose the min neighbor
         * 102ms
         */

        int n = grid.length;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> grid[o1 / n][o1 % n] - grid[o2 / n][o2 % n]
        );
        queue.offer(0);
        int res = 0;
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int p = queue.poll();
            int x = p / n, y = p % n;
            res = Math.max(res, grid[x][y]);

            if (x == n - 1 && y == n - 1) {
                return res;
            }

            for (int[] d: direction) {
                int r = x + d[0];
                int c = y + d[1];
                int rc = r * n + c;
                if (r >= 0 && r < n && c >= 0 && c < n && !visited.contains(rc)) {
                    queue.offer(rc);
                    visited.add(rc);
                }
            }
        }
        return 0;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.swimInWater(new int[][]{
                {0, 2},
                {1, 3}
        })); // 3

        System.out.println(s.swimInWater(new int[][]{
                { 0, 1, 2, 3, 4},
                {24,23,22,21, 5},
                {12,13,14,15,16},
                {11,17,18,19,20},
                {10, 9, 8, 7, 6}
        })); // 16
	}
}