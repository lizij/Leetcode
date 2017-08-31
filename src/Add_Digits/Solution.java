package Add_Digits;

public class Solution {
    public int addDigits(int num) {
        if (num < 10) return num;
        int r = num % 9;
        return r == 0 ? 9 : r;
    }

    public static void main(String[] args) {

    }
}
