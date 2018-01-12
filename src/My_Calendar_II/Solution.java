package My_Calendar_II;

import java.util.TreeMap;

public class Solution {
    MyCalendarTwo calendarTwo;
    public Solution() {
        calendarTwo = new MyCalendarTwo();
    }

    /**
     * Use TreeMap to record start and end as (time, active events)
     * Return false if active events >= k (any values), then restore to previous one. Other wise return true.
     * 557ms
     */
    class MyCalendarTwo {
        TreeMap<Integer, Integer> calendar;

        public MyCalendarTwo() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            calendar.put(start, calendar.getOrDefault(start, 0) + 1);
            calendar.put(end, calendar.getOrDefault(end, 0) - 1);

            int active = 0;
            for (Integer i: calendar.values()) {
                active += i;
                if (active >= 3) {
                    calendar.put(start, calendar.get(start) - 1);
                    calendar.put(end, calendar.get(end) + 1);
                    return false;
                }
            }
            return true;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.calendarTwo.book(10, 20)); // true
		System.out.println(s.calendarTwo.book(50, 60)); // true
		System.out.println(s.calendarTwo.book(10, 40)); // true
		System.out.println(s.calendarTwo.book(5, 15)); // false
		System.out.println(s.calendarTwo.book(5, 10)); // true
		System.out.println(s.calendarTwo.book(25, 55)); // true
	}
}