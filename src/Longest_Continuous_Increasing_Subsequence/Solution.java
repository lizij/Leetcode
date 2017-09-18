package Longest_Continuous_Increasing_Subsequence;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        for (int i = 1, count = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]){
                count++;
                res = Math.max(res, count);
            }
            else{
                count = 1;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));//3
        StdOut.println(s.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));//1
	}
}