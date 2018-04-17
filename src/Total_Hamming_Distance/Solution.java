package Total_Hamming_Distance;



public class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0, N = nums.length;
        //brute force
//        for (int i = 0; i < N; i++) {
//            for (int j = i + 1; j < N; j++) {
//                sum += Integer.bitCount(nums[i] ^ nums[j]);
//            }
//        }

        //counting bit, only different bit will contribute to hamming distance.
        //For example, k of '1' and n-k of '0' will contribute k*(n-k) to sum, while '1' with '1' or '0' with '0' won't work.
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int j = 0; j < N; j++) {
                bitCount += (nums[j] >> i) & 1;
            }
            sum += bitCount * (N - bitCount);
        }
        return sum;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.totalHammingDistance(new int[]{11, 8, 7, 4}));
	}
}