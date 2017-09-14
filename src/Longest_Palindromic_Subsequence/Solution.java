package Longest_Palindromic_Subsequence;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] memo = new int[s.length()][s.length()];
        return generate(s.toCharArray(), 0, s.length() - 1, memo);
    }

    private int generate(char[] chars, int lo, int hi, int[][] memo){
        if (lo > hi) return 0;
        if (lo == hi) return 1;
        if (memo[lo][hi] == 0) {
            if (chars[lo] == chars[hi]) {
                memo[lo][hi] = 2 + generate(chars, lo + 1, hi - 1, memo);
            }
            else{
                memo[lo][hi] = Math.max(generate(chars, lo, hi - 1, memo), generate(chars, lo + 1, hi, memo));
            }
        }
        return memo[lo][hi];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.longestPalindromeSubseq("bbbab"));
        StdOut.println(s.longestPalindromeSubseq("cbbd"));
	}
}