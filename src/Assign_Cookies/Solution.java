package Assign_Cookies;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i, j;
        for (i = 0, j = 0; i < g.length && j < s.length;i++) {
            while (s[j++] < g[i]){
                if (j >= s.length) return i;
            }
        }
        return i;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        StdOut.println(s.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
	}
}