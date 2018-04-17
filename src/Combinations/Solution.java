package Combinations;



import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] marked = new boolean[n + 2];
        combine(res, 1, k, marked);
        return res;
    }

    private void combine(List<List<Integer>> res, int pos, int k, boolean[] marked){
        if (pos >= marked.length) return;
        if (k == 0){
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < marked.length; i++) {
                if (marked[i]) list.add(i);
            }
            res.add(list);
            return;
        }
        marked[pos] = true;
        combine(res, pos + 1, k - 1, marked);
        marked[pos] = false;
        combine(res, pos + 1, k, marked);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> outptu1 = s.combine(4, 2);
		for (List<Integer> list: outptu1){
		    for (Integer i: list) System.out.print(i + " ");
		    System.out.println();
        }
	}
}