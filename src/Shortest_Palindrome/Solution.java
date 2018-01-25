package Shortest_Palindrome;
public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        /**
         * Manacher solution
         * Firstly, build manacher string chs[] to treat 1-char-center and 2-chars-center as the same
         * Then extend the leftmost palindrome bounder (L) until it meets -1, the left border
         * Since we have C (the palindrome center), we are able to find the longest palindrome substring chs[0...(2*C)],
         * which is corresponding to s[0...(C-1)], then we only have to add s[C...].reverse() to the head of s
         * 15ms
         */

        char[] chs = manacherString(s);
        int L = Integer.MAX_VALUE, C = Integer.MAX_VALUE;
        int[] r = new int[chs.length];
        for (int i = chs.length - 1; i >= 0; i--) {
            r[i] = L < i ? Math.min(r[2 * C - i], i - L) : 1;
            while (i - r[i] >= 0 && i + r[i] <= chs.length - 1) {
                if (chs[i - r[i]] == chs[i + r[i]]) {
                    r[i]++;
                } else {
                    break;
                }
            }

            if (i - r[i] < L) {
                L = i - r[i];
                C = i;
            }

            if (L == -1) {
                break;
            }
        }

        return new StringBuilder(s.substring(C, s.length())).reverse().toString() + s;
    }

    private char[] manacherString(String s) {
        // return manacher string like '#a#b#a'
        char[] res = new char[2 * s.length() + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : s.charAt(index++);
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.shortestPalindrome("acecaa")); // "aaacecaaa"
		System.out.println(s.shortestPalindrome("abcd")); // "dcbaabcd"
	}
}