package Minimum_Number_of_Arrows_to_Burst_Balloons;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        for (int i = 0, last = points[0][1]; i < points.length; i++) {
            if (last < points[i][0]){
                last = points[i][1];
                count++;
            }
        }
        return count;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] input1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        StdOut.println(s.findMinArrowShots(input1));
        int[][] input2 = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        StdOut.println(s.findMinArrowShots(input2));
	}
}