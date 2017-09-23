package Climbing_Stairs;
public class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, int[] memo){
        if (n == 1 || n == 2) return n;
        if (memo[n] == 0) memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        return memo[n];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}