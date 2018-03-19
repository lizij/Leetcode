package Preimage_Size_of_Factorial_Zeroes_Function;
public class Solution {
    public int preimageSizeFZF(int K) {
        if (K < 0) {
            return 0;
        }

        /**
         * Copied from https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/discuss/117821/Four-binary-search-solutions-based-on-different-ideas
         * 7ms
         */

        return (int)(binarySearch(K) - binarySearch(K - 1));
    }

    private long binarySearch(int K) {
        long lo = 0, hi = 5L * (K + 1);
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long k = numOfTrailingZeros(mid);

            if (k <= K) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }

    private long numOfTrailingZeros(long x) {
        long res = 0;

        for (; x > 0; x /= 5) {
            res += x/5;
        }

        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.preimageSizeFZF(0));
	}
}