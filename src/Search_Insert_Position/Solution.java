package Search_Insert_Position;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int lo, int hi){
        if (lo > hi) return lo;
        int mid = (lo + hi) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) return binarySearch(nums, target, lo, mid - 1);
        else return binarySearch(nums, target, mid + 1, hi);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        StdOut.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        StdOut.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
        StdOut.println(s.searchInsert(new int[]{1, 3, 5, 6}, 0));
	}
}