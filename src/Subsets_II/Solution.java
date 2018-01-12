package Subsets_II;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        /**
         * DFS solution
         * 4ms
         */
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
//        dfs(nums, res, new HashSet<>(), 0, new ArrayList<>());
        dfs(nums, res, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int startIndex, List<Integer> set) {
        // subset means it does not need contain all elements, so the condition is <= rather than ==
        // and do not return after this statement
        if (startIndex <= nums.length) {
            res.add(new ArrayList<>(set));
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                // avoid duplicates start
                continue;
            }
            set.add(nums[i]);
            dfs(nums, res, i + 1, set);
            set.remove(set.size() - 1);
        }
    }

    private void dfs(int[] nums, List<List<Integer>> res, Set<String> visited, int i, List<Integer> set) {
        if (i == nums.length) {
            List<Integer> arr = new ArrayList<>(set);
            String sign = arr.toString();
            if (!visited.contains(sign)) {
                res.add(arr);
                visited.add(sign);
            }
            return;
        }
        set.add(nums[i]);
        dfs(nums, res, visited, i + 1, set);
        set.remove(set.size() - 1);
        dfs(nums, res, visited, i + 1, set);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.subsetsWithDup(new int[]{1, 2, 2})); // [[2],[1],[1,2,2],[2,2],[1,2],[]]
	}
}