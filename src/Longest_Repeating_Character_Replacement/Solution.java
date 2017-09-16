package Longest_Repeating_Character_Replacement;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int N = s.length();
        int[] count = new int[26];
        int maxCount = 0, maxLength = 0, start = 0;
        for (int end = 0; end < N; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k){
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.characterReplacement("ABAB", 2));
        StdOut.println(s.characterReplacement("AABABBA", 1));
	}
}