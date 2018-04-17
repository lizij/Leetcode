package Unique_Paths;



public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        return generate(m, n, memo);
    }

    private int generate(int m, int n, int[][] memo){
        if (m == 1 || n == 1) return 1;
        if (memo[m][n] > 0) return memo[m][n];
        memo[m][n] = generate(m - 1, n, memo) + generate(m, n - 1, memo);
        return memo[m][n];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.uniquePaths(2, 2));//2
        System.out.println(s.uniquePaths(1, 10));//1
	}
}