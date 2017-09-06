package Single_Number_II;

import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
            if (i + 1 <= nums.length - 1 && nums[i + 1] == nums[i]) continue;
            return nums[i];
        }
        return -1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}