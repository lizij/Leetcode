package Partition_Labels;

import sun.nio.cs.ext.MacHebrew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }

        List<Integer> res = new ArrayList<>();

        /**
         * Greedy solution:
         * 1. Treat every char's appearance as intervals, remember the index of its first and last appearance
         * 2. Use PriorityQueue queue to store and sort intervals
         * 3. Each time we poll 2 intervals, if they intersects, we merge them and add it back to queue
         * else we remains the 2nd interval and add the 1st to results, until no interval in queue
         * 74ms
         */

//        Interval[] intervals = new Interval[26];
//
//        for (int i = 0; i < S.length(); i++) {
//            int index = S.charAt(i) - 'a';
//            if (intervals[index] == null) {
//                intervals[index] = new Interval(i, i);
//            } else {
//                intervals[index].end = i;
//            }
//        }
//
//        PriorityQueue<Interval> queue = new PriorityQueue<>(((o1, o2) -> o1.start - o2.start));
//        for (Interval intv: intervals) {
//            if (intv != null) {
//                queue.offer(intv);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            Interval cur = queue.poll();
//            if (queue.isEmpty()) {
//                res.add(cur.end - cur.start + 1);
//                break;
//            }
//            Interval next = queue.peek();
//            if (Math.max(cur.start, next.start) <= Math.min(cur.end, next.end)) {
//                next = queue.poll();
//                Interval intv = new Interval(Math.min(cur.start, next.start), Math.max(cur.end, next.end));
//                queue.offer(intv);
//            } else {
//                res.add(cur.end - cur.start + 1);
//            }
//        }
        /**
         * Greedy solution optimized: only consider the last occurrence fo a letter
         * When we add a result, the start is certain, so we only need to extend the end
         * 16ms
         */
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int j = 0, anchor = 0;
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                res.add(i - anchor + 1);
                anchor = i + 1;
            }
        }

        return res;
    }

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", start, end);
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.partitionLabels("ababcbacadefegdehijhklij")); // [9,7,8]
	}
}