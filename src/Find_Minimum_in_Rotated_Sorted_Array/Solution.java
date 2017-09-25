package Find_Minimum_in_Rotated_Sorted_Array;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]){
                res = nums[i + 1];
                break;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.findMin(new int[]{4, 5, 0, 1, 2, 3}));
	}
}