package Excel_Sheet_Column_Number;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int titleToNumber(String s) {
        int n = 0;
        for (int i = 0; i < s.length();n = n * 26 + s.charAt(i) - 'A' + 1, i++);
        return n;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.titleToNumber("A"));
        StdOut.println(s.titleToNumber("AA"));
        StdOut.println(s.titleToNumber("BAZ"));
    }
}