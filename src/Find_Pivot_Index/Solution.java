package Find_Pivot_Index;
public class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        /**
         * Compute the whole sum then judge if the current sum is half of the whole sum
         * 38ms
         */

        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * curSum == sum - nums[i]) {
                return i;
            }
            curSum += nums[i];
        }

        return -1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.pivotIndex(new int[]{1,7,3,6,5,6})); // 3
		System.out.println(s.pivotIndex(new int[]{1,2,3})); // -1
		System.out.println(s.pivotIndex(new int[]{-1,-1,-1,-1,-1,-1})); // 2
	}
}