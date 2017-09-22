package Find_Right_Interval;

import Others.Interval;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        HashMap<Interval, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {map.put(intervals[i], i); }
        List<Map.Entry<Interval, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(o -> o.getKey().start));
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Interval, Integer> cur = list.get(i);
            int j = i + 1;
            for (; j < intervals.length; j++) {
                if (list.get(j).getKey().start >= cur.getKey().end){
                    res[cur.getValue()] = list.get(j).getValue();
                    break;
                }
            }
            if (j >= intervals.length) res[cur.getValue()] = -1;
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        int[] output1 = s.findRightInterval(new Interval[]{new Interval(1, 2)});
        for (int i: output1) StdOut.print(i + " ");StdOut.println();
        int[] output2 = s.findRightInterval(new Interval[]{new Interval(3, 4), new Interval(2, 3), new Interval(1, 2)});
        for (int i: output2) StdOut.print(i + " ");StdOut.println();
        int[] output3 = s.findRightInterval(new Interval[]{new Interval(1, 4), new Interval(2, 3), new Interval(3, 4)});
        for (int i: output3) StdOut.print(i + " ");StdOut.println();
	}
}