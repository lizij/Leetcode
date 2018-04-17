package Counting_Bits;



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
            System.out.print(bits[i] + " ");
        }
    }
}
