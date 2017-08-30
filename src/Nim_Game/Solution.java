package Nim_Game;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean canWinNim(int n) {//only remove 1-3
        if (n % 4 == 0) return false;
        else return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        StdOut.println(s.canWinNim(3));
        StdOut.println(s.canWinNim(4));
        StdOut.println(s.canWinNim(5));
    }
}
