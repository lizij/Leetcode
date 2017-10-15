package Find_Minimum_in_Rotated_Sorted_Array_II;
public class Solution {
    public int findMin(int[] nums) {
        /**
         * simple traverse once to find min
         * 1ms
         */
//        int res = Integer.MAX_VALUE;
//        for (int num : nums) {
//            res = Math.min(res, num);
//        }
//        return res;
        /**
         * binary search
         * 1ms
         */
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < nums[hi]) hi = mid;
            else if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi--;
        }
        return nums[lo];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}