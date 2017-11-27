package Degree_of_an_Array;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Freq> map = new HashMap<>();
        map.put(nums[0], new Freq(1, 0, 0));
        Freq most = map.get(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Freq tmp = map.get(nums[i]);
                tmp.freq++;
                tmp.end = i;
                if (tmp.freq > most.freq || tmp.freq == most.freq && (tmp.end - tmp.start) < (most.end - most.start)) {
                    most = tmp;
                }
            }
            else {
                Freq tmp = new Freq(1, i, i);
                map.put(nums[i], tmp);
            }
        }
        return most.end - most.start + 1;
    }

    class Freq {
        int freq;
        int start;
        int end;

        public Freq(int freq, int start, int end) {
            this.freq = freq;
            this.start = start;
            this.end = end;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        StdOut.println(s.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
	}
}