package Maximum_Sum_of_3_Non_Overlapping_Subarrays;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        /**
         * regular solution o((n-k+1)^3)
         * First, record every k subarrays sum
         * Then isSameParent max value by trying every loops
         * TLE 29/37
         */
        if (nums == null || nums.length < 3 * k) return null;
        int n = nums.length;
        int[] sums = new int[n - k + 1];
        for (int i = 0, sum = 0; i < n; i++) {
            sum += nums[i];
            if (i < k - 1) continue;
            sums[i - k + 1] = sum;
            sum -= nums[i - k + 1];
        }
        int[] res = {0, k, 2 * k};
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i + k; j < n - k + 1; j++) {
                for (int l = j + k; l < n - k + 1; l++) {
                    if (sums[i] + sums[j] + sums[l] > sums[res[0]] + sums[res[1]] + sums[res[2]]) {
                        res = new int[]{i, j, l};
                    }
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] output = s.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2);
        for (int n: output) StdOut.print(n + " ");
	}
}