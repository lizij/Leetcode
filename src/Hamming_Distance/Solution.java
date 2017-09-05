package Hamming_Distance;
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}