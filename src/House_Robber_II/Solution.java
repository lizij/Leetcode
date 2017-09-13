package House_Robber_II;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    private int rob(int[] nums, int lo, int hi) {
        if (nums == null || nums.length == 0 || lo > hi) return 0;
        int rub = 0, norub = 0;
        for (int i = lo; i <= hi; i++) {
            int tmp = norub;//rub i - 2 and before
            norub = Math.max(norub, rub);//max of rub i - 2 before and i - 1 before
            rub = nums[i] + tmp;//rub i
        }
        return Math.max(rub, norub);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        StdOut.println(s.rob(new int[]{1, 1, 1}));
//        StdOut.println(s.rob(new int[]{0}));
        StdOut.println(s.rob(new int[]{2, 1}));
	}
}