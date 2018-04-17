package Longest_Harmonious_Subsequence;



import java.util.*;

public class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (int key: map.keySet()){
            if (map.containsKey(key + 1)){
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.findLHS(new int[]{1,3,2,2,5,2,3,7}));
	}
}