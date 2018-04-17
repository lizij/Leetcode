package House_Robber;



public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        /**
         * calculate the max if i rub the house at i
         * dp[i] = nums[i] + max(dp[i - 3] + dp[i - 2])
         * 1ms
         */
//        if (nums.length == 1) return nums[0];
//        int N = nums.length;
//        int[] dp = new int[N];
//        for (int i = 0; i < N; i++) {
//            int pre = 0;
//            if (i - 3 >= 0) pre = Math.max(pre, dp[i - 3]);
//            if (i - 2 >= 0) pre = Math.max(pre, dp[i - 2]);
//            dp[i] = nums[i] + pre;
//        }
//        return Math.max(dp[N - 1], dp[N - 2]);
        /**
         * calculate the max rub the house or not
         * rub : rub this and the last last house before
         * norub : don't rub this
         */
        int rub = 0, norub = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = norub;//rub i - 2 and before
            norub = Math.max(norub, rub);//max of rub i - 2 before and i - 1 before
            rub = nums[i] + tmp;//rub i
        }
        return Math.max(rub, norub);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.rob(new int[]{4, 3, 5, 9, 3, 4, 5}));
	}
}