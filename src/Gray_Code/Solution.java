package Gray_Code;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) return Arrays.asList(0);
        if (n == 1) return Arrays.asList(0, 1);
        if (n == 2) return Arrays.asList(0, 1, 3, 2);
        List<Integer> res = new ArrayList<>();
        res.add(0);res.add(1);res.add(3);res.add(2);
        for (int lo = 2, hi = res.size() - 1; n > 2; n--) {
            for (int i = lo; i < hi; i += 2) {
                res.add((res.get(i) << 1));
                res.add((res.get(i) << 1) + 1);
                res.add((res.get(i + 1) << 1) + 1);
                res.add((res.get(i + 1) << 1));
            }
            lo = lo << 1;hi = res.size() - 1;
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        List<Integer> output1 = s.grayCode(4);
        for (Integer i: output1) StdOut.print(i + " ");
	}
}