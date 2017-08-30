package Distribute_Candies;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < candies.length; i++) set.add(candies[i]);
        return Math.min(set.size(), candies.length / 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input1 = {1, 1, 2, 2, 3, 3};
        int[] input2 = {1, 1, 2, 3};
        StdOut.println(s.distributeCandies(input1));
        StdOut.println(s.distributeCandies(input2));
    }
}
