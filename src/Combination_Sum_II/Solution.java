package Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return null;
        }
        /**
         * DFS solution
         * The difference is using sort and nums[i] == nums[i - 1] to filter the same number and avoid duplicate sets.
         * 19ms
         */

        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int target, int startIndex, List<Integer> tmp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] > target || i > startIndex && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            backtrack(nums, target - nums[i], i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
		/*
		[
          [1, 7],
          [1, 2, 5],
          [2, 6],
          [1, 1, 6]
        ]
		 */
    }
}