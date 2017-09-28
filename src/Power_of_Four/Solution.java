package Power_of_Four;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean isPowerOfFour(int num) {
        return (num & (num - 1)) == 0 && ((num - 1) % 3) == 0;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		StdOut.println(s.isPowerOfFour(16));
		StdOut.println(s.isPowerOfFour(5));
		StdOut.println(s.isPowerOfFour(-128));
	}
}