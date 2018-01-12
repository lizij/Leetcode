package Others;

import java.util.ArrayList;
import java.util.List;

public class Interval {
    public int start;
    public int end;
    public Interval() { start = 0; end = 0; }
    public Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "{" + start + ","  + end + "}";
    }

    public static List<Interval> getIntervalList(int[] time) {
        if (time == null || time.length == 0 || (time.length & 1) != 0) {
            throw new IllegalArgumentException("Invalid time list");
        }

        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < time.length; i += 2) {
            res.add(new Interval(time[i], time[i + 1]));
        }
        return res;
    }
}
