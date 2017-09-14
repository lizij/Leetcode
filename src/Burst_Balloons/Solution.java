package Burst_Balloons;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    int res;
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        /**
         * nums[-1] = nums[n] = 1
         * Reverse thinking: Mark i as the last balloon to be bursted. Therefore the last coins added is nums[lo] * nums[i] * nums[hi].
         * Now divide the problem into two parts: burst balloons from lo to i and i to hi. Because i is the last one, the left ones of i won't influence the right ones.
         * memo[lo][hi] means that the max result burst from lo to hi
         * 12ms
         */
        int N = nums.length;
        int[] balloons = new int[N + 2];
        System.arraycopy(nums, 0, balloons, 1, N);
        balloons[0] = balloons[N + 1] = 1;
        int[][] memo = new int[N + 2][N + 2];
        return burst(balloons, 0, N + 1, memo);
        /**
         * nearly brute force, list all possible results and find the max one
         * O(n!), time limit exceeded
         */
//        if (nums.length == 1) return nums[0];
//        List<Integer> balloons = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        res = 0;
//        burst(balloons, 0);
//        return res;
    }

    private int burst(int[] balloons, int lo, int hi, int[][] memo){
        if (memo[lo][hi] > 0) return memo[lo][hi];
        int res = 0;
        for (int i = lo + 1; i <= hi - 1; i++) {
            int tmp = balloons[lo] * balloons[i] * balloons[hi] + burst(balloons, lo, i, memo) + burst(balloons, i, hi, memo);
            res = Math.max(res, tmp);
        }
        memo[lo][hi] = res;
        return res;
    }

    private void burst(List<Integer> balloons, int coins){
        if (balloons.size() == 2){
            res = Math.max(res, balloons.get(0) * balloons.get(1) + Math.max(balloons.get(0), balloons.get(1)) + coins);
            return;
        }
        int N = balloons.size();
        for (int i = 0; i < N; i++) {
            Integer val = balloons.get(i);
            int tmp = val;
            if (i - 1 >= 0) tmp *= balloons.get(i - 1);
            if (i + 1 < N) tmp *= balloons.get(i + 1);
            balloons.remove(i);
            burst(balloons, coins + tmp);
            balloons.add(i, val);
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.maxCoins(new int[]{3, 1, 5, 8}));
//        StdOut.println(s.maxCoins(new int[]{2, 3, 7, 9, 1, 8, 2}));
	}
}