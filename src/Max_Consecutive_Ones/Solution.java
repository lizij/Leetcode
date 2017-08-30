package Max_Consecutive_Ones;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        StdOut.println(s.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        StdOut.println(s.findMaxConsecutiveOnes(new int[]{1}));
        StdOut.println(s.findMaxConsecutiveOnes(new int[]{0}));
    }
}
