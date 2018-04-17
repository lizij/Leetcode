package Combination_Sum;



import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /**
         * Backtrack solution
         * For every i, use or not
         * If meet target, remember the current sequence
         * 21ms
         */
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, int target, List<List<Integer>> res, List<Integer> list, int start){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) continue;
            list.add(nums[i]);
            backtrack(nums, target - nums[i], res, list, i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(s.combinationSum(new int[]{1, 2}, 4));
    }
}