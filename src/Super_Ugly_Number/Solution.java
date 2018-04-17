package Super_Ugly_Number;



import java.util.Arrays;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] index = new int[primes.length];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(ugly[i], ugly[index[j]] * primes[j]);
            }

            for (int j = 0; j < primes.length; j++) {
                index[j] += ugly[i] == ugly[index[j]] * primes[j] ? 1 : 0;
            }
        }
        return ugly[n - 1];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.nthSuperUglyNumber(12, new int[]{2,7,13,19}));//1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32
	}
}