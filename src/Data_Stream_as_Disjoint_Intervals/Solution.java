package Data_Stream_as_Disjoint_Intervals;

import Others.Interval;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Solution{
    SummaryRanges summaryRanges;
    public Solution(){
        summaryRanges = new SummaryRanges();
    }
    public class SummaryRanges {
        List<Integer> data;
        /** Initialize your data structure here. */
        public SummaryRanges() {
            data = new ArrayList<>();
        }

        public void addNum(int val) {
            int pos = 0;
            while (pos < data.size() && data.get(pos) < val) pos++;
            data.add(pos, val);
        }

        public List<Interval> getIntervals() {
            List<Interval> res = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                int start = data.get(i);
                int end = start;
                for (int j = i + 1; j < data.size(); j++) {
                    if (data.get(j) <= end + 1){
                        end = data.get(j);
                        i = j;
                    }
                }
                res.add(new Interval(start, end));
            }
            return res;
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
	public static void main(String[] args) {
		Solution s = new Solution();
		s.summaryRanges.addNum(1);
		for (Interval interval: s.summaryRanges.getIntervals()) StdOut.print(interval + " ");StdOut.println();
        s.summaryRanges.addNum(3);
        for (Interval interval: s.summaryRanges.getIntervals()) StdOut.print(interval + " ");StdOut.println();
        s.summaryRanges.addNum(7);
        for (Interval interval: s.summaryRanges.getIntervals()) StdOut.print(interval + " ");StdOut.println();
        s.summaryRanges.addNum(2);
        for (Interval interval: s.summaryRanges.getIntervals()) StdOut.print(interval + " ");StdOut.println();
        s.summaryRanges.addNum(6);
        for (Interval interval: s.summaryRanges.getIntervals()) StdOut.print(interval + " ");StdOut.println();
	}
}