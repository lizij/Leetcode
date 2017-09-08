package Maximum_Product_of_Three_Numbers;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        return Math.max(nums[0] * nums[1] * nums[N - 1], nums[N - 3] * nums[N - 2] * nums[N - 1]);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.maximumProduct(new int[]{1, 2, 3}));
        StdOut.println(s.maximumProduct(new int[]{1, 2, 3, 4}));
        StdOut.println(s.maximumProduct(new int[]{1, 2, 3, -4}));
        StdOut.println(s.maximumProduct(new int[]{1, 2, -3, -4}));
	}
}