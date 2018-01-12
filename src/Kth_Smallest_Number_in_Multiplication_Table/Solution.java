package Kth_Smallest_Number_in_Multiplication_Table;

import java.util.PriorityQueue;

public class Solution {
    public int findKthNumber(int m, int n, int k) {
        if (m < 1 || n < 1 || k < 1 || k > m * n) {
            return 0;
        }

        /**
         * Use PriorityQueue to store k smallest number then return peek()
         * TLE
         */

//        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                int value = i * j;
//                if (queue.size() < k || value < queue.peek()) {
//                    queue.offer(value);
//                    if (queue.size() > k) {
//                        queue.poll();
//                    }
//                }
//            }
//        }
//        return queue.peek();

        /**
         * Binary Search solution
         * 28ms
         */

        int lo = 1;
        int hi = m * n + 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            int count = 0;
            for (int i = 1; i <= m; i++) {
                // In row i, Math(mid / i, n) is the quantity of the numbers smaller than mid
                count += Math.min(mid / i, n);
            }
            if (count > k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findKthNumber(3, 3, 5)); // 3 (1, 2, 2, 3, 3)
        System.out.println(s.findKthNumber(2, 3, 6)); // 6 (1, 2, 2, 3, 4, 6)
	}
}