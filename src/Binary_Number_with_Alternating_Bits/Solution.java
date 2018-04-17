package Binary_Number_with_Alternating_Bits;



public class Solution {
    public boolean hasAlternatingBits(int n) {
		/**
		 * bit compute
		 * 17ms
		 */
		return ((n ^= (n >> 1)) & (n + 1)) == 0;
		/**
		 * use bit string
		 * 13ms
		 */
//		char[] bytes = Integer.toBinaryString(n).toCharArray();
//		for (int i = 0; i < bytes.length - 1; i++) {
//			if (bytes[i] == bytes[i + 1]) return false;
//		}
//		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.hasAlternatingBits(5));//true
		System.out.println(s.hasAlternatingBits(7));//false
		System.out.println(s.hasAlternatingBits(11));//false
		System.out.println(s.hasAlternatingBits(10));//true
	}
}