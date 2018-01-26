package Prime_Number_of_Set_Bits_in_Binary_Representation;

import Others.Interval;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countPrimeSetBits(int L, int R) {
        if (L > R) {
            return 0;
        }
        /**
         * List all primes in [0, 32] and use bitCount()
         * 45ms
         */
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        int res = 0;
        for (int i = L; i <= R; i++) {
            if (primes.contains(Integer.bitCount(i))) {
                res++;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.countPrimeSetBits(6, 10)); // 4
		System.out.println(s.countPrimeSetBits(10, 15)); // 5
	}
}