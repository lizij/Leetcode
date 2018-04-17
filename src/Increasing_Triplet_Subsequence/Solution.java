package Increasing_Triplet_Subsequence;



public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        /**
         * make use of if else to mark the min value and second min value of array
         * 6ms
         */
        for (int i: nums){
            if (i <= min) min = i;
            else if (i <= secondMin) secondMin = i;
            else return true;
        }
        /**
         * isSameParent min value before i and max value after i and check (min, nums[i], max)
         * 101ms
         */
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (minOfArray(nums, 0, i - 1) < nums[i] && nums[i] < maxOfArray(nums, i + 1, nums.length - 1)) return true;
//        }
        return false;
    }

    private int maxOfArray(int[] nums, int lo, int hi){
        int max = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) { max = Math.max(max, nums[i]); }
        return max;
    }

    private int minOfArray(int[] nums, int lo, int hi){
        int min = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) { min = Math.min(min, nums[i]); }
        return min;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(s.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(s.increasingTriplet(new int[]{5,1,5,5,2,5,4}));
	}
}