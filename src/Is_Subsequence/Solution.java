package Is_Subsequence;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        for (int i = 0, pos = 0; i < t.length(); i++) {
            if (s.charAt(pos) == t.charAt(i)) pos++;
            if (pos == s.length()) return true;
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.isSubsequence("abc", "ahbgdc"));
        StdOut.println(s.isSubsequence("axc", "ahbgdc"));
        StdOut.println(s.isSubsequence("ace", "abcde"));
        StdOut.println(s.isSubsequence("aec", "abcde"));
	}
}