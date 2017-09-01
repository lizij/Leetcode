package Product_of_Array_Except_Self;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        res[0] = 1;
        for (int i = 1; i < N; i++) {               //res = {1, nums[0], nums[0] * nums[1], ..., nums[0] * nums[1] * ...* nums[N - 2]}
            res[i] = res[i - 1] * nums[i - 1];
        }

        for (int i = N - 1, tmp = 1; i >= 0; i--) { //res[i] = res[i] * nums[i + 1] *...* nums[N - 1] = res[i] * tmp[i]
            res[i] *= tmp;                          //tmp[i] = tmp[i + 1] * nums[i + 1]
            tmp *= nums[i];
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		for (int i: s.productExceptSelf(new int[]{1, 2, 3, 4})) StdOut.print(i + " ");
	}
}