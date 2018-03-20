package Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return null;
        }
        /**
         * DFS solution
         * The difference is that the result array's size must be equal to k
         * 1ms
         */
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        backtrack(nums, n, k, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int target, int quantity, int startIndex, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() > quantity) {
            return;
        }

        if (target == 0 && tmp.size() == quantity) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] > target) continue;
            tmp.add(nums[i]);
            backtrack(nums, target - nums[i], quantity, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.combinationSum3(3, 7));
		System.out.println(s.combinationSum3(3, 9));
	}
}