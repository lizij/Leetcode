package Predict_the_Winner;



public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int N = nums.length;
        return predict(nums, 0, N - 1, new Integer[N][N]) >= 0;
    }

    private int predict(int[] nums, int lo, int hi, Integer[][] mem){
        if (mem[lo][hi] == null){
            mem[lo][hi] = lo == hi ? nums[lo] : Math.max(nums[lo] - predict(nums, lo + 1, hi, mem), nums[hi] - predict(nums, lo, hi - 1, mem));
        }
        return mem[lo][hi];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(s.PredictTheWinner(new int[]{1, 5, 233, 7}));
	}
}