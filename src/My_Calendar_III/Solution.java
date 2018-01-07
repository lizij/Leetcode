package My_Calendar_III;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {

    private MyCalendarThree calendarThree;

    public Solution() {
        calendarThree = new MyCalendarThree();
    }

    class MyCalendarThree {
        TreeMap<Integer, Integer> timeline;

        public MyCalendarThree() {
            timeline = new TreeMap<>();
        }

        public int book(int start, int end) {
            timeline.put(start, timeline.getOrDefault(start, 0) + 1);
            timeline.put(end, timeline.getOrDefault(end, 0) - 1);

            int active = 0;
            int res = 0;
            for (Integer i: timeline.values()) {
                active += i;
                res = active > res ? active : res;
            }
            return res;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();

        System.out.println(s.calendarThree.book(10, 20)); // returns 1
        System.out.println(s.calendarThree.book(50, 60)); // returns 1
        System.out.println(s.calendarThree.book(10, 40)); // returns 2
        System.out.println(s.calendarThree.book(5, 15)); // returns 3
        System.out.println(s.calendarThree.book(5, 10)); // returns 3
        System.out.println(s.calendarThree.book(25, 55)); // returns 3
	}
}