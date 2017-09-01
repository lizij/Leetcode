package Range_Addition_II;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            minX = Math.min(minX, ops[i][0]);
            minY = Math.min(minY, ops[i][1]);
        }
        return minX * minY;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}));
	}
}