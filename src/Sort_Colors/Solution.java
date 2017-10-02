package Sort_Colors;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        /**
         * use Arrays.sort built in Java
         * 1ms
         */
//        Arrays.sort(nums);

        /**
         * Two pass solution: record and rewrite
         * 0ms
         */
//        int[] colors = new int[3];
//        for (int num : nums) colors[num]++;
//        int pos = 0;
//        for (int i = 0; i < colors.length; i++) {
//            for (int j = 0; j < colors[i]; j++) {
//                nums[pos++] = i;
//            }
//        }

        /**
         * One pass solution(refer to Lomuto partition algorithm):
         * For every i, firstly record the original value of nums[i] then set nums[i] as 2
         * If the value < 2, it could be 0 or 1. In either case the end index of 1 should plus one.
         * If the value = 0, the end index of 0 should plus one.
         * This method guarantees that oneEnd will increase faster than zeroEnd.
         * 0ms
         */
        int zeroEnd = 0, oneEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            nums[i] = 2;
            if (val < 2) nums[oneEnd++] = 1;
            if (val == 0) nums[zeroEnd++] = 0;
        }
    }

    public static void main(String[] args) {
		Solution s = new Solution();
	}
}