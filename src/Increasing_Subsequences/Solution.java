package Increasing_Subsequences;



import java.util.*;
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        /**
         * use Set to remove duplicate results.
         * 54ms
         */
        Set<List<Integer>> set = new HashSet<>();
        helper(nums, new ArrayList<>(), 0, set);
        return new ArrayList<>(set);
    }

    private void helper(int[] nums, List<Integer> list, int pos, Set<List<Integer>> set){
        if (pos == nums.length) {
            if (list.size() >= 2) set.add(new ArrayList<>(list));
            return;
        }
        if (list.size() == 0 || list.get(list.size() - 1) <= nums[pos]) {
            list.add(nums[pos]);
            helper(nums, list, pos + 1, set);
            list.remove(list.size() - 1);
        }
        helper(nums, list, pos + 1, set);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.findSubsequences(new int[]{4, 6, 7, 7}));//[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7, 7], [4, 7, 7]]
	}
}