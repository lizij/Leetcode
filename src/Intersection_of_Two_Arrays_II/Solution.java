package Intersection_of_Two_Arrays_II;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums1) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i: nums2){
            if (map.containsKey(i)){
                int value = map.get(i);
                if (value > 0){
                    res.add(i);
                    map.put(i, value - 1);
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        for (int i :s.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})) {
            StdOut.print(i + " ");
        }
    }
}