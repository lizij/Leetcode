package Power_of_Four;



public class Solution {
    public boolean isPowerOfFour(int num) {
        return (num & (num - 1)) == 0 && ((num - 1) % 3) == 0;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPowerOfFour(16));
		System.out.println(s.isPowerOfFour(5));
		System.out.println(s.isPowerOfFour(-128));
	}
}