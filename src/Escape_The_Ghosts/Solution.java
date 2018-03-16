package Escape_The_Ghosts;
public class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        if (target == null || target.length != 2) {
            // no target or invalid target
            return false;
        }

        if (ghosts == null || ghosts.length == 0) {
            // no ghosts
            return true;
        }

        /**
         * Define dist(A, B) = abs(A.x - B.x) + abs(A.y - B.y)
         * We start at S, a ghost at G, target is T, if we meet the ghost at X, we can get:
         * dist(S, X) >= dist(G, X)
         * Because X is one point in the path to T, so
         * dist(G, T) <= dist(G, X) + dist(X, T) <= dist(S, X) + dist(X, T)
         * while dist(S, T) <= dist(S, X) + dist(X, T)
         * Therefore, if dist(G, T) <= dist(S, T), we will definitely be caught by a ghost
         * 7ms
         */

        int[] src = {0, 0};
        for (int[] g: ghosts) {
            if (dist(g, target) <= dist(src, target)) {
                return false;
            }
        }
        return true;
    }

    private int dist(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.escapeGhosts(new int[][]{{1, 0}, {0, 3}}, new int[]{0, 1})); // true
		System.out.println(s.escapeGhosts(new int[][]{{1, 0}}, new int[]{2, 0})); // false
		System.out.println(s.escapeGhosts(new int[][]{{2, 0}}, new int[]{1, 0})); // false
	}
}