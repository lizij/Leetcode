package Pyramid_Transition_Matrix;

import java.util.*;

public class Solution {
    int[][] map;
    Set<Long> solvedRow;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        /**
         * Copied from AC Solution
         * Build a map from the list of allowed triples
         * Because letters can only be chose from 'A' to 'G', we can use 7 bits to represents them
         */
        map = new int[7][7];
        for (String s: allowed) {
            // use 7 bits to represent letters in ['A', ‘G’]
            map[s.charAt(0) - 'A'][s.charAt(1) - 'A'] |= 1 << (s.charAt(2) - 'A');
        }

        solvedRow = new HashSet<>();

        // set the bottom of pyramid
        int N = bottom.length();
        int[][] pyramid = new int[N][N]; // representing the pyramid
        int t = 0;
        for (char c: bottom.toCharArray()) {
            pyramid[N - 1][t++] = c - 'A';
        }
        return solve(pyramid, 0, N - 1, 0);
    }

    public boolean solve(int[][] pyramid, long curRow, int length, int index) {
        if (length == 1 && index == 1) { // If successfully placed entire pyramid
            return true;
        } else if (index == length) {
            if (solvedRow.contains(curRow)) {
                return false; // If we've already tried this row, give up
            }
            solvedRow.add(curRow); // Add row to cache
            return solve(pyramid, 0, length - 1, 0); // Calculate next row
        } else {
            // w's jth bit is true if block #j could be a parent of pyramid[N][i] and pyramid[N][i+1]
            int w = map[pyramid[length][index]][pyramid[length][index+1]];
            // for each set bit in w...
            for (int b = 0; b < 7; ++b) {
                if (((w >> b) & 1) != 0) {
                    pyramid[length-1][index] = b; //set parent to be equal to block #b
                    //If rest of pyramid can be built, return true
                    // current row's ith bit set to b+1 in base 8.
                    if (solve(pyramid, curRow * 8 + (b + 1), length, index + 1)) return true;
                }
            }
            return false;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.pyramidTransition("ABC", Arrays.asList("ABD", "BCE", "DEA", "FFF"))); // true
		System.out.println(s.pyramidTransition("AABA", Arrays.asList("AAA", "AAB", "ABA", "ABB", "BAC"))); // false
	}
}