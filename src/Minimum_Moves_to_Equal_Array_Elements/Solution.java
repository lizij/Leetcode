package Minimum_Moves_to_Equal_Array_Elements;

import java.util.stream.IntStream;

public class Solution {
    public int minMoves(int[] nums) {
        int sum = IntStream.of(nums).sum();
        int min = IntStream.of(nums).min().getAsInt();
        return sum - min * nums.length;
    }
}
