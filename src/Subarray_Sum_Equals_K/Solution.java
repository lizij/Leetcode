package Subarray_Sum_Equals_K;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) res+= map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        StdOut.println(s.subarraySum(new int[]{1, 1, 1}, 2));
//        StdOut.println(s.subarraySum(new int[]{1}, 0));
        StdOut.println(s.subarraySum(new int[]{-1, -1, 1}, 0));
	}
}