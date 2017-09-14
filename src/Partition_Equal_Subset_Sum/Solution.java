package Partition_Equal_Subset_Sum;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i: nums) sum += i;
        return (sum & 1) == 0 && subSetSum(nums, sum / 2);
    }

    private boolean subSetSum(int[] nums, int s){
        boolean[] dp = new boolean[s + 1];//all possible values from 0 - s
        dp[0] = true;//choose no one
        for (int i: nums) {
            for (int j = s; j >= i; j--) {  //based on the previous result, calculate how many j can be formed by j - i plus i
                dp[j] = dp[j] || dp[j - i];          //why traverse in descending order:In this way, the impossible results won't be influenced.
            }                               // If we traverse in ascending order, the previous result changed and larger results started to emerge.
        }                                   // Impossible results will emerge because it is based on j and j has already add i once. It will add i twice and that's incorrect.
        return dp[s];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        StdOut.println(s.canPartition(new int[]{1, 5, 11, 5}));
//        StdOut.println(s.canPartition(new int[]{1, 2, 3, 5}));
//        StdOut.println(s.canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100}));
//        StdOut.println(s.canPartition(new int[]{66,90,7,6,32,16,2,78,69,88,85,26,3,9,58,65,30,96,11,31,99,49,63,83,79,97,20,64,81,80,25,69,9,75,23,70,26,71,25,54,1,40,41,82,32,10,26,33,50,71,5,91,59,96,9,15,46,70,26,32,49,35,80,21,34,95,51,66,17,71,28,88,46,21,31,71,42,2,98,96,40,65,92,43,68,14,98,38,13,77,14,13,60,79,52,46,9,13,25,8}));
        StdOut.println(s.canPartition(new int[]{18,40,62,33,83,64,10,92,67,31,42,51,10,97,41,7,82,71,80,81,41,38,88,25,38,89,24,89,90,12,97,21,22,85,11,59,83,6,51,47,32,82,83,100,29,78,36,32,1,31,36,19,35,3,36,21,24,93,42,33,10,26,2,39,36,62,85,24,41,5,66,53,7,1,59,53,40,59,41,95,7,67,20,29,80,59,49,49,51,90,13,52,6,90,5,6,31,81,95,26}));
	}
}