package Monotone_Increasing_Digits;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int monotoneIncreasingDigits(int N) {
        /**
         * Greedy solution
         * If N in [0, 9]: return N
         * Get every digits of N, for digits[i]:
         * If digits[i] > digits[i + 1]: we need to digits[i]--, then set digits[(i+1)...] as 9.
         * But if digits[i - 1] > digits[i] after digits[i]--
         * we need to find the most front i which won't have this problem before setting.
         * 22ms
         */
        // [0, 9], return itself
//        if (N <= 9) {
//            return N;
//        }
//
//        List<Integer> digits = getDigits(N); // get all digits
//        for (int i = 0; i < digits.size() - 1; i++) {
//            if (digits.get(i) > digits.get(i + 1)) {
//                // if digits[i] > digits[i + 1]: digits[i]--, digits[(i+1)...] = 9
//                digits.set(i, digits.get(i) - 1);
//                while (i - 1 >= 0 && digits.get(i) < digits.get(i - 1)) {
//                    digits.set(i - 1, digits.get(i - 1) - 1);
//                    i--;
//                }
//
//                for (int j = i + 1; j < digits.size(); j++) {
//                    digits.set(j, 9);
//                }
//                break;
//            }
//        }
//
//        int res = 0;
//        for (int i = 0; i < digits.size(); i++) {
//            res = res * 10 + digits.get(i);
//        }
//
//        return res;

        /**
         * Use string to get digits and do the same thing, more faster
         *
         */
        char[] S = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < S.length && S[i-1] <= S[i]) i++;
        while (0 < i && i < S.length && S[i-1] > S[i]) S[--i]--;
        for (int j = i+1; j < S.length; ++j) S[j] = '9';

        return Integer.parseInt(String.valueOf(S));
    }

    private List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(0, n % 10);
            n /= 10;
        }
        return digits;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.monotoneIncreasingDigits(10)); // 9
		System.out.println(s.monotoneIncreasingDigits(1234)); // 1234
		System.out.println(s.monotoneIncreasingDigits(332)); // 299
		System.out.println(s.monotoneIncreasingDigits(33425)); // 33399
	}
}