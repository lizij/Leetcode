package Elimination_Game;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int lastRemaining(int n) {
        if (n == 0) return 0;
        /**
         * brute force
         * time limit exceeded at 2200+
         */
//        List<Integer> res = new ArrayList<>();
//        for (int i = 1; i <= n; i++) res.add(i);
//        int step = 2;
//        boolean right = true;
//        while (res.size() > 1){
//            Integer i;
//            if (right) i = res.get(0);
//            else i = res.get(res.size() - 1);
//            while (res.contains(i)){
//                res.remove(i);
//                i += step;
//            }
//            step = -2 * step;
//            right = !right;
//        }
//        return res.get(0);
        /**
         * only calculate the head one from left
         */
        int step = 1, res = 1, lo = 1, hi = n;
        while (lo < hi){
            lo += step;
            hi -= step;
            step *= 2;
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        for (int i = 0; i < 50; i++) {
            StdOut.println(i + ":" + s.lastRemaining(i));
        }
	}
}