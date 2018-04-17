package Number_of_1_Bits;



public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /**
         * use bitCount built in Java
         * 2ms
         */
//        return Integer.bitCount(n);
        /**
         * Iterate every bit of n
         * 2ms
         */
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (n >>> i) & 1;
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.hammingWeight(11));
	}
}