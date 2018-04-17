package Unique_Binary_Search_Trees;



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
        System.out.println(s.numTrees(3));
        System.out.println(s.numTrees(4));
	}
}