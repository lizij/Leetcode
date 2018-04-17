package Ugly_Number_II;



public class Solution {
    public int nthUglyNumber(int n) {
        /**
         * http://www.geeksforgeeks.org/ugly-numbers/
         */
        int[] ugly = new int[n];
        int[] prime = {2, 3, 5};
        int[] index = new int[prime.length];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < prime.length; j++) {
                ugly[i] = Math.min(ugly[i], ugly[index[j]] * prime[j]);
            }
            for (int j = 0; j < prime.length; j++) {
                index[j] += ugly[i] == ugly[index[j]] * prime[j] ? 1 : 0;
            }
        }
        return ugly[n - 1];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.nthUglyNumber(10));
	}
}