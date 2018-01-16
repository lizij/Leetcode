package Partition_to_K_Equal_Sum_Subsets;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k < 0) {
            return false;
        }

        /**
         * DFS solution
         * 20ms
         */

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int target = sum / k;


        if (sum % k > 0 || max > target) {
            return false;
        }

        boolean[] visited = new boolean[nums.length];
        return dfs(nums, visited, 0, k, 0, 0, target);
    }

    private boolean dfs(int[] nums, boolean[] visited, int startIndex, int k, int curSum, int curNum, int target) {
        if (k == 1) {
            return true;
        }
        if (curSum == target && curNum > 0) {
            return dfs(nums, visited, 0, k - 1, 0, 0, target);
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, visited, i + 1, k, curSum + nums[i], curNum++, target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4)); // true
		System.out.println(s.canPartitionKSubsets(new int[]{5,2,5,5,5,5,5,5,5,5,5,5,5,5,5,3}, 15)); // true
	}
}