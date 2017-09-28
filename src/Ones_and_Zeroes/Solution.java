package Ones_and_Zeroes;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        /**
         * For each string s:
         * Firstly count the number of 0 and 1 of s needs.
         * memo[i][j] means the max number of strings that can be formed from i 0's and j 1's from the first string to s
         * There are two cases: use s, get memo[i - count[0]][j - count[1]] + 1, or do nothing and get original memo[i][j].
         * Because we need to get current result from previous results, it is necessary to go from bottom right to top left.
         * Otherwise, the results from this iteration will be used, resulting in overcounting.
         * 50ms
         */
        int[][] memo = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = count(s);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    memo[i][j] = Math.max(memo[i][j], memo[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return memo[m][n];
    }

    private int[] count(String s) {
        int[] chars = new int[2];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - '0']++;
        }
        return chars;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.findMaxForm(new String[]{"10","0001","111001","1","0"},5,3));//4
        StdOut.println(s.findMaxForm(new String[]{"10","1","0"},1,1));//2
        StdOut.println(s.findMaxForm(new String[]{"10","0001","111001","1","0"},4,3));//3
        StdOut.println(s.findMaxForm(new String[]{"0","11","1000","01","0","101","1","1","1","0","0","0","0","1","0","0110101","0","11","01","00","01111","0011","1","1000","0","11101","1","0","10","0111"},9,80));//17
	}
}