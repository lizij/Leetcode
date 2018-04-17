package Nim_Game;



public class Solution {
    public boolean canWinNim(int n) {//only remove 1-3
        if (n % 4 == 0) return false;
        else return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canWinNim(3));
        System.out.println(s.canWinNim(4));
        System.out.println(s.canWinNim(5));
    }
}
