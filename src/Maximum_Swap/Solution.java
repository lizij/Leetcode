package Maximum_Swap;

import edu.princeton.cs.algs4.StdOut;
public class Solution {
    public int maximumSwap(int num) {
        /**
         * Traverse digits from left to right and record every last position of digit 0-9 in this num,
         * Then traverse again and for every digit, find the largest one from the record to swap with.
         * In a word, try to swap the smaller ones in the left part, with the larger ones in the right part.
         */
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                if (buckets[j] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[j]];
                    digits[buckets[j]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.maximumSwap(2736));//7236
        StdOut.println(s.maximumSwap(9973));//9973
	}
}