package Unique_Binary_Search_Trees;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                memo[i] += memo[j] * memo[i - j - 1];
            }
        }
        return memo[n];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.numTrees(3));
        StdOut.println(s.numTrees(4));
	}
}