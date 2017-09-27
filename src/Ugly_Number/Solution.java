package Ugly_Number;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean isUgly(int num) {
        if (num == 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.isUgly(6));
        StdOut.println(s.isUgly(8));
        StdOut.println(s.isUgly(14));
	}
}