package Power_of_Three;

import Others.Interval;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean isPowerOfThree(int n) {
        while (n % 3 == 0)n /= 3;
        return n == 1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.isPowerOfThree(27));
        StdOut.println(s.isPowerOfThree(45));
	}
}