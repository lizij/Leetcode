package Combination_Sum;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, int target, List<List<Integer>> res, List<Integer> list, int start){
        if (target == 0){
            if (!res.contains(list)) res.add(new ArrayList<>(list));
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
        StdOut.println(s.combinationSum(new int[]{2, 3, 6, 7}, 7));
        StdOut.println(s.combinationSum(new int[]{1, 2}, 4));
	}
}