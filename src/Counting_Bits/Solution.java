package Counting_Bits;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = Integer.bitCount(i);
        }
        return bits;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] bits = s.countBits(5);
        for (int i = 0; i < bits.length; i++) {
            StdOut.print(bits[i] + " ");
        }
    }
}
