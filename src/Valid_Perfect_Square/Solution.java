package Valid_Perfect_Square;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean isPerfectSquare(int num) {
        long lo = 0, hi = num, mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            long val = mid * mid;
            if (val == num) return true;
            if (num < val) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.isPerfectSquare(16));
        StdOut.println(s.isPerfectSquare(14));
	}
}