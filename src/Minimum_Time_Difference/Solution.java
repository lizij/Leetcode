package Minimum_Time_Difference;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null) return 0;
        int N = timePoints.size();
        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            String[] t = timePoints.get(i).split(":");
            times[i] = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min, Math.min(times[i + 1] - times[i], 24 * 60 + times[i] - times[i + 1]));
        }
        min = Math.min(min, Math.min(times[N - 1] - times[0], 24 * 60 + times[0] - times[N - 1]));
        return min;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		List<String> input1 = Arrays.asList("23:59", "00:02", "00:00", "02:10", "17:59", "20:22", "23:50");
        StdOut.println(s.findMinDifference(input1));
    }
}