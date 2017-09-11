package Delete_Operation_for_Two_Strings;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] mem = new int[word1.length()][word2.length()];
        int lcs = lcs(word1.toCharArray(), word1.length() - 1, word2.toCharArray(), word2.length() - 1, mem);
        return word1.length() + word2.length() - 2 * lcs;
    }

    private int lcs(char[] a, int alen, char[] b, int blen, int[][] mem){
        if (alen < 0 || blen < 0) return 0;
        if (mem[alen][blen] == 0) {
            if (a[alen] == b[blen]) mem[alen][blen] = lcs(a, alen - 1, b, blen - 1, mem) + 1;
            else mem[alen][blen] = Math.max(lcs(a, alen - 1, b, blen, mem), lcs(a, alen, b, blen - 1, mem));
        }
        return mem[alen][blen];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.minDistance("sea", "eat"));
        StdOut.println(s.minDistance("sea", "ate"));
	}
}