package _1_bit_and_2_bit_Characters;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
    	int n = bits.length;
		for (int i = 0; i < n; i++) {
			if (i == n - 1) return true;
			if (bits[i] == 0) continue;
			i++;
		}
		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		StdOut.println(s.isOneBitCharacter(new int[]{1, 0, 0}));
		StdOut.println(s.isOneBitCharacter(new int[]{1, 1, 1, 0}));
		StdOut.println(s.isOneBitCharacter(new int[]{0}));
	}
}