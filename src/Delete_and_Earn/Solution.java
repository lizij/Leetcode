package Delete_and_Earn;

import java.util.*;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        /**
         * Brute force
         * From every i try to delete and isSameParent the max points
         * TLE
         */
//        boolean[] visited = new boolean[nums.length];
//        return deleteAndEarn(nums, visited, 0);

        /**
         * Similar with House Robber
         * The problem limits n in nums: [1, 10000]. Thus we make 10001 buckets. In each bucket, we put the sum of all same number.
         * eg. for [2, 2, 3, 3, 3, 4], the buckets is [0 * 0, 0 * 0, 2 * 2, 3 * 3， 1 * 4]
         * This problem becomes that if we choose one bucket, we can take all points in the bucket then must abandon the adjacent ones.
         * Like robber in House Robber, if we rob one house, we can't rob neighbored ones.
         *
         */
        int[] buckets = new int[10001];
        for (int n: nums) {
            buckets[n] += n;
        }

        int rub = 0, norub = 0;
        for (int i = 0; i < buckets.length; i++) {
            int tmp = norub;//rub i - 2 and before
            norub = Math.max(norub, rub);//max of rub i - 2 before and i - 1 before
            rub = buckets[i] + tmp;//rub i
        }
        return Math.max(rub, norub);
    }

    private int deleteAndEarn(int[] nums, boolean[] visited, int deletedNumber) {
        if (deletedNumber == nums.length) {
            return 0;
        }

        int maxPoints = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                List<Integer> deletedIndexes = delete(nums, i, visited);
                int points = nums[i] + deleteAndEarn(nums, visited, deletedNumber + deletedIndexes.size());
                restore(visited, deletedIndexes);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        return maxPoints;
    }

    private List<Integer> delete(int[] nums, int index, boolean[] visited) {
        List<Integer> indexes = new ArrayList<>();
        visited[index] = true;
        indexes.add(index);
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && Math.abs(nums[i] - nums[index]) == 1) {
                visited[i] = true;
                indexes.add(i);
            }
        }
        return indexes;
    }

    private void restore(boolean[] visited, List<Integer> indexes) {
        for (int i: indexes) {
            visited[i] = false;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.deleteAndEarn(new int[]{3, 4, 2})); // 6
		System.out.println(s.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4})); // 9
	}
}