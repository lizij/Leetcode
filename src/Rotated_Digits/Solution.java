package Rotated_Digits;

public class Solution {
    public int rotatedDigits(int N) {
        if (N <= 0) {
            return 0;
        }

        /**
         * 21ms
         */

        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isGood(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean isGood(int n) {
        String s = Integer.toString(n);

        String[] invalid = {"3", "4", "7"};
        String[] good = {"2", "5", "6", "9"};

        for (String c: invalid) {
            if (s.contains(c)) {
                return false;
            }
        }

        for (String c: good) {
            if (s.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rotatedDigits(20)); // 4
    }
}
