package Maximum_Sum_of_3_Non_Overlapping_Subarrays;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        /**
         * Regular solution o(n)
         * First, record every k sub arrays' sum
         * Then find max value by trying every loops
         * 11ms
         */
        if (nums == null || nums.length < 3 * k) return null;
        int n = nums.length;
        int[] sums = new int[n - k + 1];

        // compute sum[j...(j + k - 1)], j in range [0, n - k]
        for (int i = 0, sum = 0; i < n; i++) {
            sum += nums[i];
            if (i < k - 1) continue;
            // i >= k - 1
            sums[i - k + 1] = sum; // 0 <= i - k + 1 <= n - k
            sum -= nums[i - k + 1]; // reduce nums[i - k + 1] ahead of time
        }

        int[] left = new int[sums.length]; // left[i]: largest sum's index in range [0, i]
        int largest = 0;
        for (int i = 0; i < sums.length; i++) {
            largest = sums[i] > sums[largest] ? i : largest;
            left[i] = largest;
        }

        int[] right = new int[sums.length]; // right[i]: largest sum's index in range [i, sums.length - 1]
        largest = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            largest = sums[i] > sums[largest] ? i : largest;
            right[i] = largest;
        }

        int[] res = {0, k, 2 * k};
        for (int i = k; i < sums.length - k; i++) {
            // sums[left[i - k]]: largest sum in range [0, i - k]
            // sums[right[i + k]]: largest sum in range [i + k, sums.length - 1]
            if (sums[i] + sums[left[i - k]] + sums[right[i + k]] > sums[res[0]] + sums[res[1]] + sums[res[2]]) {
                res = new int[]{left[i - k], i, right[i + k]};
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2)));
	}
}