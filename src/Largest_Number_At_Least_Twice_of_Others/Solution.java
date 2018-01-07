package Largest_Number_At_Least_Twice_of_Others;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        PriorityQueue<Num> queue = new PriorityQueue<Num>((o1, o2) -> o2.value - o1.value);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new Num(nums[i], i));
        }

        Num max = queue.poll();
        Num secondMax = queue.poll();
        return max.value >= 2 * secondMax.value ? max.index : -1;
    }

    class Num {
        int value;
        int index;

        public Num(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.dominantIndex(new int[]{3, 6, 1, 0})); // 1
		System.out.println(s.dominantIndex(new int[]{1, 2, 3, 4})); // -1
	}
}