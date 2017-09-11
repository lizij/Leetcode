package Bulb_Switcher_II;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    boolean[] state;
    List<boolean[]> res;
    int N;
    public int flipLights(int n, int m) {
        /**
         * when n > 2 and m >= 3, the result is 8. Return result directly if n <= 2 and m < 3.
         * 1ms ?
         */
        if(m==0) return 1;
        if(n==1) return 2;
        if(n==2&&m==1) return 3;
        if(n==2) return 4;
        if(m==1) return 4;
        if(m==2) return 7;
        if(m>=3) return 8;
        return 8;
        /**
         * calculate all possible results
         * time limit exceeded...
         */
//        state = new boolean[n + 1];
//        Arrays.fill(state, true);
//        res = new ArrayList<>();
//        N = n;
//        generate(m, state);
//        return res.size();
    }

    private void generate(int m, boolean[] state){
        if (m == 0){
            for (int i = 0; i < res.size(); i++) {
                boolean[] b = res.get(i);
                int j = 1;
                for (; j < b.length; j++) {
                    if (state[j] != b[j]) break;
                }
                if (j == b.length) return;
            }
            res.add(state);
            return;
        }

        boolean[] flipAll = copy(state);
        boolean[] flipOdd = copy(state);
        boolean[] flipEven = copy(state);
        boolean[] flipOther = copy(state);
        for (int i = 1; i < state.length; i++) {
            flipAll[i] = !flipAll[i];
            if ((i & 1) == 1) flipOdd[i] = !flipOdd[i];
            if ((i & 1) == 0) flipEven[i] = !flipEven[i];
            if (i % 3 == 1) flipOther[i] = !flipOther[i];
        }
        generate(m - 1, flipAll);
        generate(m - 1, flipOdd);
        generate(m - 1, flipEven);
        generate(m - 1, flipOther);
    }

    private boolean[] copy(boolean[] a){
        boolean[] b = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.flipLights(3, 1));
	}
}