package Target_Sum;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        /**
         * use HashMap to memorize all possible results with their quantity in every step
         * 112ms
         */
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(nums[0], 1);map.put(-nums[0], map.getOrDefault(-nums[0], 0) + 1);
//        for (int i = 1; i < nums.length; i++) {
//            map = generate(map, nums, i);
//        }
//        return map.getOrDefault(S, 0);
        /**
         * use subsetSum
         * P: positive ones, N: negative ones, A: all ones
         * sum(P) - sum(N) = S
         * sum(P) + sum(N) + sum(P) - sum(N) = S + sum(P) + sum(N)
         * 2 * sum(P) = S + sum(A)
         * 14ms
         */
        int sum = 0;
        for (int i: nums) sum += i;
        return sum < S || ((sum + S) & 1) != 0 ? 0 : subSetSum(nums, (sum + S) / 2);
    }

    private int subSetSum(int[] nums, int s){
        int[] dp = new int[s + 1];//all possible values from 0 - s
        dp[0] = 1;//choose no one
        for (int i: nums){
            for (int j = s; j >= i; j--) {  //based on the previous result, calculate how many j can be formed by j - i plus i
                dp[j] += dp[j - i];          //why traverse in descending order:In this way, the impossible results won't be influenced.
                                            // If we traverse in ascending order, the previous result changed and larger results started to emerge.
                                            // Impossible results will emerge because it is based on j and j has already add i once. It will add i twice and that's incorrect.
            }
        }
        return dp[s];
    }

    private HashMap<Integer, Integer> generate(HashMap<Integer, Integer> map, int[] nums, int k){
        HashMap<Integer, Integer> newMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            int plus = entry.getKey() + nums[k];
            int minus = entry.getKey() - nums[k];
            newMap.put(plus, newMap.getOrDefault(plus, 0) + entry.getValue());
            newMap.put(minus, newMap.getOrDefault(minus, 0) + entry.getValue());
        }
        return newMap;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        StdOut.println(s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
//        StdOut.println(s.findTargetSumWays(new int[]{1}, 3));
//        StdOut.println(s.findTargetSumWays(new int[]{3}, 3));
        StdOut.println(s.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
	}
}