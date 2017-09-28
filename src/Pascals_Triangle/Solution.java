package Pascals_Triangle;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lastLine = new ArrayList<>();
        while (res.size() < numRows) {
            lastLine.add(0, 1);
            for (int i = 1; i < lastLine.size() - 1; i++) {
                lastLine.set(i, lastLine.get(i) + lastLine.get(i + 1));
            }
            res.add(new ArrayList<>(lastLine));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        StdOut.println(s.generate(5));
    }
}
