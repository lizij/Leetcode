package Combination_Sum_III;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] marked = new boolean[10];
        generate(marked, k, n, 1, res);
        return res;
    }

    private void generate(boolean[] marked, int k, int n, int start, List<List<Integer>> res){
        if (k < 0 || n < 0) return;
        if (n == 0 && k == 0){
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                if (marked[i]) list.add(i);
            }
            if (!res.contains(list)) res.add(list);
            return;
        }
        for (int i = start; i < 10; i++) {
            if (i > n) continue;
            marked[i] = true;
            generate(marked, k - 1, n - i, i + 1, res);
            marked[i] = false;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		for (List<Integer> list: s.combinationSum3(3, 7)){
		    for (Integer i: list){
                StdOut.print(i + ",");
            }
            StdOut.print(" ");
        }
        StdOut.println();
        for (List<Integer> list: s.combinationSum3(3, 9)){
            for (Integer i: list){
                StdOut.print(i + ",");
            }
            StdOut.print(" ");
        }
	}
}