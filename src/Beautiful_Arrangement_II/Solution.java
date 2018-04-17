package Beautiful_Arrangement_II;



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
//        for (int i: s.constructArray(3, 1)) System.out.print(i + " ");System.out.println();
//        for (int i: s.constructArray(3, 2)) System.out.print(i + " ");System.out.println();
        for (int i: s.constructArray(7, 4)) System.out.print(i + " ");System.out.println();
    }
}
