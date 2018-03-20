package Combination_Sum_IV;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        return generate(target, nums, map);
        /**
         * DP solution
         * From bottom to up, calculate the possible result for every number in [0, target]
         * 5ms
         */
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int curTarget = 1; curTarget < dp.length; curTarget++) {
            for (int i = 0; i < nums.length; i++) {
                if (curTarget >= nums[i]) {
                    dp[curTarget] += dp[curTarget - nums[i]];
                }
            }
        }
        return dp[target];
    }

    private int generate(int target, int[] nums, HashMap<Integer, Integer> map){
        if (target == 0) return  1;
        if (map.containsKey(target)) return map.get(target);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                int subRes = generate(target - nums[i], nums, map);
                res += subRes;
            }
        }
        map.put(target, res);
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.combinationSum4(new int[]{1, 2, 3}, 4));
        StdOut.println(s.combinationSum4(new int[]{9}, 3));
        StdOut.println(s.combinationSum4(new int[]{}, 3));
        StdOut.println(s.combinationSum4(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, 10));
	}
}