package Subarray_Sum_Equals_K;



import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        /**
         * Using a HashMap to store the cumulative sum
         * as the form (sum[i], no. of occurrences of sum[i])
         * Traverse over the array nums and keep on finding the cumulative sum
         * Every time we encounter a new sum, we make a new entry in the HashMap
         * corresponding to that sum in the HashMap.
         * Also we determine the number of times the sum sum[i] - k has occured already
         * since it will determine the number of times a subarray with sum k has occured upto the current index.
         * We increment the count by the same amount.
         * 43ms
         */
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i]; // current sum
            if (map.containsKey(sum - k)) {
                // There is a subarray sum equals to sum-k
                // which means there is a subarray sum equals to k
                res+= map.get(sum - k);
            }
            // store the occurrences of  the subarray sum in map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
//        System.out.println(s.subarraySum(new int[]{1}, 0));
        System.out.println(s.subarraySum(new int[]{-1, -1, 1}, 0));
	}
}