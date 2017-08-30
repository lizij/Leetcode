package Single_Number;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
            if (i + 1 <= nums.length - 1 && nums[i + 1] == nums[i]) continue;
            return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        StdOut.println(s.singleNumber(new int[]{1, 1, 2, 2, 3, 4, 4}));
    }
}
