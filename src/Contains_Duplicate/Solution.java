package Contains_Duplicate;

import java.util.Arrays;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}