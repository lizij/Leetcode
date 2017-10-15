package Trapping_Rain_Water;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int lo = 0, hi = height.length - 1, maxLo = 0, maxHi = 0, res = 0;
        while (lo <= hi) {
            if (height[lo] < height[hi]) {
                maxLo = Math.max(maxLo, height[lo]);
                res += Math.max(0, maxLo - height[lo]);
                lo++;
            } else {
                maxHi = Math.max(maxHi, height[hi]);
                res += Math.max(0, maxHi - height[hi]);
                hi--;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));//6
	}
}