package Maximum_Average_Subarray_I;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        double sum = 0, max = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / k;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
	}
}