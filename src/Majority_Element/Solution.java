package Majority_Element;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > nums.length / 2) return entry.getKey();
        }
        return -1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}