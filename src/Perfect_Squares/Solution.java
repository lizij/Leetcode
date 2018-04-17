package Perfect_Squares;



import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numSquares(int n) {
        /**
         * Static squares & Dynamic Programming
         * 119ms
         */
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        return helper(squares, n, new int[n + 1]);
    }

    private int helper(List<Integer> squares, int target, int[] memo) {
        if (target == 0) return 0;
        if (memo[target] > 0) return memo[target];
        memo[target] = Integer.MAX_VALUE;
        for (int i = 0; i < squares.size(); i++) {
            if (squares.get(i) > target) break;
            int left = helper(squares,target - squares.get(i), memo);
            memo[target] = Math.min(memo[target], left + 1);
        }
        return memo[target];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numSquares(1));
        System.out.println(s.numSquares(12));//4+4+4 3
        System.out.println(s.numSquares(13));//4+9 2
	}
}