package Merge_Intervals;

import Others.Interval;

import java.util.List;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        /**
         * Greedy solution: sort by start end merge
         * 107ms
         */

        intervals.sort((o1, o2) -> o1.start - o2.start);
        int pos = 0;
        while (pos < intervals.size() - 1) {
            Interval cur = intervals.get(pos);
            Interval next = intervals.get(pos + 1);
            if (Math.max(cur.start, next.start) <= Math.min(cur.end, next.end)) {
                cur.start = Math.min(cur.start, next.start);
                cur.end = Math.max(cur.end, next.end);
                intervals.remove(next);
            } else {
                pos++;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.merge(Interval.getIntervalList(new int[]{1, 3, 2, 6, 8, 10, 15, 18}))); // [1,6],[8,10],[15,18]
	}
}