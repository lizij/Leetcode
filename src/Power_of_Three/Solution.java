package Power_of_Three;

import Others.Interval;


public class Solution {
    public boolean isPowerOfThree(int n) {
        while (n % 3 == 0)n /= 3;
        return n == 1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.isPowerOfThree(27));
        System.out.println(s.isPowerOfThree(45));
	}
}