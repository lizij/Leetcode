package Optimal_Division;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public String optimalDivision(int[] nums) {
        int N = nums.length;
        if (N == 0) return "";
        if (N == 1) return String.valueOf(nums[0]);
        if (N == 2) return nums[0] + "/" + nums[1];
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < N; i++) {
            builder.append("/" + nums[i]);
        }
        builder.append(')');
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        StdOut.println(s.optimalDivision(new int[]{1000,100,10,2}));
        StdOut.println(s.optimalDivision(new int[]{6,2,3,4,5}));
        StdOut.println(s.optimalDivision(new int[]{2,3,4}));
    }
}
