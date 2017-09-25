package Contiguous_Array;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){ sum++; }
            else if (nums[i] == 0){ sum--; }
            if (map.containsKey(sum)){
                res = Math.max(res, i - map.get(sum));
            }
            else{ map.put(sum, i); }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.findMaxLength(new int[]{0, 1}));
        StdOut.println(s.findMaxLength(new int[]{0, 1, 0}));
        StdOut.println(s.findMaxLength(new int[]{0,1,1,0,1,1,0,1,0,1,0,1,1,1,0}));
	}
}