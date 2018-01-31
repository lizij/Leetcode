package Max_Chunks_To_Make_Sorted_II;

import java.util.*;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        /**
         * Partition solution
         * Compute rightMin[i] of arr[i...(n-1)]
         * If leftMax[i] of arr[0...i] < rightMax[i + 1], arr[0...i] can be a chunk
         * 12ms
         */

        int n = arr.length;
        int[] rightMin = new int[n];
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        int res = 1, leftMax = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            if (leftMax <= rightMin[i + 1]) {
                res++;
            }
        }

        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.maxChunksToSorted(new int[]{5,4,3,2,1})); // 1
		System.out.println(s.maxChunksToSorted(new int[]{2,1,3,4,4})); // 4
		System.out.println(s.maxChunksToSorted(new int[]{4,2,2,1,1})); // 1
	}
}