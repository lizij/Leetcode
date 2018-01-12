package Employee_Free_Time;

import Others.Interval;

import java.util.*;

public class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        /**
         * Use TreeMap to build a time line, a key for a time point, a value for the change of people quantity
         * Use active to remember people at work. When active decreases to 0, the free time begins until active become positive again.\
         * 56ms
         */
        TreeMap<Integer, Integer> timeLine = new TreeMap<>();
        for (List<Interval> s: schedule) {
            for (Interval intv: s) {
                timeLine.put(intv.start, timeLine.getOrDefault(intv.start, 0) + 1);
                timeLine.put(intv.end, timeLine.getOrDefault(intv.end, 0) - 1);
            }
        }

        List<Map.Entry<Integer, Integer>> timeList = new ArrayList<>(timeLine.entrySet());
        int active = timeList.get(0).getValue();
        List<Interval> res = new ArrayList<>();
        int freeTimeStart = -1;
        for (int i = 1; i < timeList.size(); i++) {
            Map.Entry<Integer, Integer> entry = timeList.get(i);
            if (freeTimeStart > 0) {
                res.add(new Interval(freeTimeStart, entry.getKey()));
                freeTimeStart = -1;
            }
            active += entry.getValue();
            if (active == 0) {
                freeTimeStart = entry.getKey();
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.employeeFreeTime(Arrays.asList(
		        Interval.getIntervalList(new int[]{1, 2, 5, 6}),
                Interval.getIntervalList(new int[]{1, 3}),
                Interval.getIntervalList(new int[]{4, 10})
        ))); // [[3,4]]
        System.out.println(s.employeeFreeTime(Arrays.asList(
                Interval.getIntervalList(new int[]{1, 3, 6, 7}),
                Interval.getIntervalList(new int[]{2, 4}),
                Interval.getIntervalList(new int[]{2, 5, 9, 12})
        ))); // [[5,6],[7,9]]
	}
}