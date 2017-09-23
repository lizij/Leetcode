package Power_of_Two;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.isPowerOfTwo(1024));
	}
}