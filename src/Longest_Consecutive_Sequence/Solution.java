package Longest_Consecutive_Sequence;



import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        /**
         * sort and count
         * 4ms
         */
//        Arrays.sort(nums);
//        int res = 1, count = 1;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i + 1] == nums[i] + 1) count++;
//            else if (nums[i + 1] > nums[i] + 1) count = 1;
//            res = Math.max(res, count);
//        }

        /**
         * set solution
         * 12ms
         */
        Set<Integer> set = new HashSet<>();
        for (int n: nums) set.add(n);
        int res = 1;
        for (int n: nums) {
            if (!set.contains(n)) continue;
            set.remove(n);
            int count = 1;
            for (int i = n - 1; set.contains(i) ; i--, count++) set.remove(i);
            for (int i = n + 1; set.contains(i) ; i++, count++) set.remove(i);

            res = Math.max(res, count);
        }

        /**
         * Map solution
         * Each time we insert a number n into Map, check if there are n - 1 or n + 1 existing in Map
         * Get the sequence length of n is in, then update boundaries.
         * 13ms
         */
//        int res = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int n: nums) {
//            // duplicates
//            if (map.containsKey(n)) continue;
//
//            // see if n - 1 and n + 1 exists
//            int left = map.getOrDefault(n - 1, 0);
//            int right = map.getOrDefault(n + 1, 0);
//
//            // the sequence length n is in
//            int sum = left + right + 1;
//            map.put(n, sum);
//
//            res = Math.max(res, sum);
//
//            // update sequence boundary
//            // will do nothing if n has no neighbors
//            map.put(n - left, sum);
//            map.put(n + right, sum);
//        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[]{100,4,200,1,3,2}));//4
        System.out.println(s.longestConsecutive(new int[]{1,3,5,2,4}));//4
	}
}