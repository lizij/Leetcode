package Single_Element_in_a_Sorted_Array;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
            if (i + 1 <= nums.length - 1 && nums[i + 1] == nums[i]) continue;
            return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input1 = {1,1,2,3,3,4,4,8,8};
        int[] input2 = {3,3,7,7,10,11,11};
        StdOut.println(s.singleNonDuplicate(input1));
        StdOut.println(s.singleNonDuplicate(input2));
    }
}
