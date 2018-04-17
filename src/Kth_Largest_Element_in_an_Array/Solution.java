package Kth_Largest_Element_in_an_Array;



import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
	}
}