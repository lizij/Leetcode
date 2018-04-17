package Minimum_Moves_to_Equal_Array_Elements_II;



import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int median = nums[nums.length/2];
        for(int num:nums) sum += Math.abs(median - num);
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minMoves2(new int[]{1, 2, 3}));
    }
}
