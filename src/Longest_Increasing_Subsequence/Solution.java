package Longest_Increasing_Subsequence;



import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int res = 0;
        int[] dp = new int[n];

        /**
         * dp[i] means the length of longest subsequence from 0 to i
         * 29ms
         */
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }

        /**
         * dp[0-res] means the longest subsequence from 0 to res.
         * In each iteration, try to insert n (in nums) in dp
         * 2ms
         */
        for (int i: nums) {
            int pos = Arrays.binarySearch(dp, 0, res, i);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = i;
            if (pos == res) {
                res++;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
//        System.out.println(s.lengthOfLIS(new int[]{-2, -1}));
        System.out.println(s.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
	}
}