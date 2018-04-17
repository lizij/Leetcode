package Split_Array_Largest_Sum;



import java.util.Arrays;

public class Solution {
    public int splitArray(int[] nums, int m) {
        /**
         * Dynamic Programming Solution
         * split array into m groups from every possible position
         * 102ms
         */
//        if (nums == null || nums.length == 0) return 0;
//        int N = nums.length;
//        int[][] memo = new int[N][m + 1];
//        return findLargestSum(nums, 0, m, memo);
        /**
         * Binary Search Solution
         * from the max of nums to the sum of nums, use binary search to narrow down boundaries.
         * valid() is to test if nums could be divided into m sub array with sum less than target
         * if it return true, that means target may be too large, so decrease right boundary. Otherwise increase left boundary.
         * 4ms
         */
        int max = 0;
        long sum = 0;
        for (int n: nums) {
            max = Math.max(max, n);
            sum += n;
        }

        if (m == 1) return (int) sum;

        long lo = max, hi = sum;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (valid(nums, mid, m)) { hi = mid - 1; }
            else { lo = mid + 1; }
        }
        return (int)lo;
    }

    private boolean valid(int[] nums, long target, int groups) {
        int count = 1;
        long sum = 0;
        for (int n: nums) {
            sum += n;
            if (sum > target) {
                sum = n;
                count++;
                if (count > groups) { return false; }
            }
        }
        return true;
    }

    private int findLargestSum(int[] nums, int pos, int group, int[][] memo) {
        if (memo[pos][group] > 0) return memo[pos][group];
        if (group == 1) {
            for (int i = pos; i < nums.length; i++) {
                memo[pos][group] += nums[i];
            }
            return memo[pos][group];
        }
        memo[pos][group] = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = pos; i <= nums.length - group; i++) {
            sum += nums[i];
            int max = Math.max(sum, findLargestSum(nums, i + 1, group - 1, memo));
            memo[pos][group] = Math.min(memo[pos][group], max);
        }
        return memo[pos][group];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.splitArray(new int[]{7,2,5,10,8}, 2));
	}
}