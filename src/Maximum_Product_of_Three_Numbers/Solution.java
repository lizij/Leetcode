package Maximum_Product_of_Three_Numbers;



import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        return Math.max(nums[0] * nums[1] * nums[N - 1], nums[N - 3] * nums[N - 2] * nums[N - 1]);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(s.maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(s.maximumProduct(new int[]{1, 2, 3, -4}));
        System.out.println(s.maximumProduct(new int[]{1, 2, -3, -4}));
	}
}