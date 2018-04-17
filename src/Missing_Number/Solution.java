package Missing_Number;



public class Solution {
    public int missingNumber(int[] nums) {
        int N = nums.length;
        /**
         * use a^b^b = a
         * 1ms
         */
        int res = 0;
        for (int i = 0; i < N; i++) {
            res ^= i ^ nums[i];
        }
        return res ^ N;
        /**
         * use marked array
         * 2ms
         */
//        boolean[] marked = new boolean[N + 1];
//        for (int i: nums) marked[i] = true;
//        for (int i = 0; i < N + 1; i++) {
//            if (!marked[i]) return i;
//        }
//        return -1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.missingNumber(new int[]{0, 1, 3}));
	}
}