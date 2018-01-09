package K_Empty_Slots;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0) return -1;
        int n = flowers.length;

        /**
         * use a array days[] to store each position's flower's blooming day.
         * then isSameParent a subarray days[lo...hi] of days[], which satisfies:
         * for i in lo+1 to hi-1, days[left] < days[i] && days[right] < days[i]
         */
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[flowers[i] - 1] = i + 1;
        }
        int lo = 0, hi = k + 1, res = Integer.MAX_VALUE;
        for (int i = 0; hi < n; i++) {
            if (days[lo] < days[i] && days[hi] < days[i]) continue;
            if (i == hi) {
                //This means that every days[i] from lo+1 to hi-1 satisfy the condition.
                res = Math.min(res, Math.max(days[lo], days[hi]));
            }
            lo = i;
            hi = i + k + 1;
        }
        return res == Integer.MAX_VALUE ? -1 : res;

        /**
         * brute force solution
         * time limit exceeded
         */
//        boolean[] blooms = new boolean[n + 1];
//        for (int i = 0; i < n; i++) {
//            blooms[flowers[i]] = true;
//            if (verify(blooms, k)) return i + 1;
//        }
//        return -1;
    }

    private boolean verify(boolean[] blooms, int k) {
        for (int i = 0, last = -1; i < blooms.length; i++) {
            if (!blooms[i]) continue;
            if (last != -1 && i - last - 1 == k) return true;
            last = i;
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.kEmptySlots(new int[]{1,3,2}, 1));//1
        StdOut.println(s.kEmptySlots(new int[]{1,2,3}, 1));//-1
	}
}