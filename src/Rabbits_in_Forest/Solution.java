package Rabbits_in_Forest;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }

        /**
         * Math solution
         * If n+1 rabbits have the same color, n+1 rabbits answered or would answer n
         * If k rabbits answered n
         * 1. k % (n+1) == 0, the number of color groups is k/(n+1)
         * 2. k % (n+1) != 0, the number of color groups is k/(n+1) + 1
         * in which one group has n+1 rabbits
         * 14ms
         */

        Map<Integer, Integer> count = new HashMap<>();
        for (int ans: answers) {
            count.put(ans, count.getOrDefault(ans, 0) + 1);
        }

        int res = 0;
        for (int n: count.keySet()) {
            int k = count.get(n);
            int numberOfGroups = k % (n + 1) == 0 ? k / (n + 1) : k / (n + 1) + 1;
            res += numberOfGroups * (n + 1);
        }

        return res;
    }

    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numRabbits(new int[]{1, 1, 2})); // 5
		System.out.println(s.numRabbits(new int[]{10, 10, 10})); // 11
		System.out.println(s.numRabbits(new int[]{})); // 0
	}
}