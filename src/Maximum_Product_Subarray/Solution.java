package Maximum_Product_Subarray;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], maxEndingHere = nums[0], minEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0){int temp = maxEndingHere;maxEndingHere = minEndingHere;minEndingHere = temp;}
            maxEndingHere = Math.max(nums[i], maxEndingHere * nums[i]);
            minEndingHere = Math.min(nums[i], minEndingHere * nums[i]);
            res = Math.max(res, maxEndingHere);
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.maxProduct(new int[]{2,3,-2,4}));
        StdOut.println(s.maxProduct(new int[]{-2,3,-4}));
	}
}