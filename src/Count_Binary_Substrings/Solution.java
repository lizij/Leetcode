package Count_Binary_Substrings;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int countBinarySubstrings(String s) {
		/**
		 * cur: the number of the current chars (0 or 1)
		 * prev: the number of the chars which is different from cur
		 * every time isSameParent a cur, means a substring will be found like 0..,01...1 or 1...10...0
		 * if prev >= cur, the current ones will be less than previous ones, a result can be counted in.
		 * 30ms
		 */
		int res = 0, prev = 0, cur = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) cur++;
			else {
				prev = cur;
				cur = 1;
			}
			if (prev >= cur) res++;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		StdOut.println(s.countBinarySubstrings("00110011"));
		StdOut.println(s.countBinarySubstrings("10101"));
	}
}