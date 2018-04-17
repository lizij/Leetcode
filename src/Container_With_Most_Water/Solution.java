package Container_With_Most_Water;
public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int res = 0;

        /**
         * Two pointer
         * This is similar with finding a value in a sorted matrix (m[i - 1][j] <+ m[i][j] <= m[i][j+1])
         * The difference is we need to record the max value during finding
         * https://leetcode.com/problems/container-with-most-water/discuss/6099/Yet-another-way-to-see-what-happens-in-the-O(n)-algorithm
         * 10ms
         */
        int l = 0, r = n - 1;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        /**
         * Brute force
         * TLE
         */

//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int contain = Math.min(height[i], height[j]) * (j - i);
//                res = Math.max(res, contain);
//            }
//        }

        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{1,2,3,4,5,6})); // 9
	}
}