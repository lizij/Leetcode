package Number_Complement;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int findComplement(int num) {
//        char[] bits = Integer.toBinaryString(num).toCharArray();
//        for (int i = 0; i < bits.length; i++) {
//            if (bits[i] == '0') bits[i] = '1';
//            else bits[i] = '0';
//        }
//        return Integer.parseInt(new String(bits), 2);
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

    private int getBit(int num, int i){
        return (num & (1 << i));
    }

    private int setBit(int num, int i, int value){
        return (num | (value << i));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        StdOut.println(s.findComplement(5));
        StdOut.println(s.findComplement(1));
        StdOut.println(s.findComplement(2));
        StdOut.println(s.findComplement(2147483647));
    }
}