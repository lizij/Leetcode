package Sliding_Window_Maximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[]{};
        }

        /**
         * Deque solution:
         * Maintain a deque to store the up-to-date max data's index
         * 27ms
         */

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove outdated data's index from first
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // remove "<=" data's index from last
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // offer nums[i] in last
            deque.offerLast(i);

            // update res
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); // [3,3,5,5,6,7]
		System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1, -1}, 1))); // [1, -1]
	}
}