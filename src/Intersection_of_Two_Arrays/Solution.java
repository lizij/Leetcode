package Intersection_of_Two_Arrays;



import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) set.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++){
            if (set.contains(nums2[i]) && !res.contains(nums2[i])) res.add(nums2[i]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		for (int i: s.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})) System.out.print(i + " ");
	}
}