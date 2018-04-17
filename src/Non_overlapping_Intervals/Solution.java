package Non_overlapping_Intervals;

import Others.Interval;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
        Interval cur = null;
        int count = 0;
        for (Interval interval: intervals){
            if (count == 0 || cur.end <= interval.start){
                cur = interval;
                count++;
            }
        }
        return intervals.length - count;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.eraseOverlapIntervals(new Interval[]{new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3)}));
        System.out.println(s.eraseOverlapIntervals(new Interval[]{new Interval(1, 2), new Interval(1, 2), new Interval(1, 2)}));
        System.out.println(s.eraseOverlapIntervals(new Interval[]{new Interval(1, 2), new Interval(2, 3)}));
	}
}