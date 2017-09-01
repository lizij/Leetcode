package Beautiful_Arrangement_II;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int insertTimes = k / 2;
        int pos = 0;
        int lo = 1, hi = n;
        for (int i = 1; i <= insertTimes; i++) {
            res[pos++] = lo++;
            res[pos++] = hi--;
        }
        for (int i = lo; i <= hi; i++) {
            res[pos++] = i;
        }
        if (k % 2 == 0 && k < n - 1){
           res[0] = n;
           res[1] = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        for (int i: s.constructArray(3, 1)) StdOut.print(i + " ");StdOut.println();
//        for (int i: s.constructArray(3, 2)) StdOut.print(i + " ");StdOut.println();
        for (int i: s.constructArray(7, 4)) StdOut.print(i + " ");StdOut.println();
    }
}
