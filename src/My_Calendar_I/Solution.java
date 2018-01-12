package My_Calendar_I;

import Others.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    MyCalendar calendar;
    public Solution() {
        calendar = new MyCalendar();
    }
    class MyCalendar {
        /**
         * Regular solution.
         * Judge if the new interval will intersect with other intervals
         * 189ms
         */
        List<Interval> intervals;

        public MyCalendar() {
            intervals = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            Interval intv = new Interval(start, end);
            if (causeDoubleBooking(intv)) {
                return false;
            }
            intervals.add(intv);
            return true;
        }

        private boolean causeDoubleBooking(Interval intv) {
            for (int i = 0; i < intervals.size(); i++) {
                if (intervals.get(i).intersect(intv)) {
                    return true;
                }
            }
            return false;
        }

        class Interval {
            int start;
            int end;

            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }

            public boolean intersect(Interval other) {
                return !(end <= other.start || start >= other.end);
            }
        }
        /**
         * Use TreeMap to store all intervals as (start, end)
         * Then find the floor key and the ceiling key to locate the possible insertion position
         * Maybe TreeMap need a lot of time to find the ceiling key and the floor keys. It's slower
         * 208ms
         */

//        TreeMap<Integer, Integer> intervals;
//        public MyCalendar() {
//            intervals = new TreeMap<>();
//        }
//
//        public boolean book(int start, int end) {
//            Integer pre = intervals.floorKey(start);
//            Integer next = intervals.ceilingKey(start);
//            if ((pre == null || intervals.get(pre) <= start)
//                    && (next == null || end <= next)) {
//                intervals.put(start, end);
//                return true;
//            }
//            return false;
//        }
    }

    /**
     * Your MyCalendar object will be instantiated and called as such:
     * MyCalendar obj = new MyCalendar();
     * boolean param_1 = obj.book(start,end);
     */
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.calendar.book(10, 20)); // true
        System.out.println(s.calendar.book(15, 25)); // false
        System.out.println(s.calendar.book(20, 30)); // true
	}
}