package Longest_Palindromic_Substring;



public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        int[] pos = new int[2];
        for (int i = 0; i < chars.length - 1; i++) {
            int[] tmp1 = extend(chars, i, i);
            int[] tmp2 = extend(chars, i, i + 1);
            if (tmp1[1] - tmp1[0] > pos[1] - pos[0]) pos = tmp1;
            if (tmp2[1] - tmp2[0] > pos[1] - pos[0]) pos = tmp2;
        }
        return s.substring(pos[0], pos[1] + 1);
    }

    private int[] extend(char[] chars, int lo, int hi){
        while (lo >= 0 && hi <= chars.length - 1 && chars[lo] == chars[hi]){
            lo--;hi++;
        }
        return new int[]{lo + 1, hi - 1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("babad"));
        System.out.println(s.longestPalindrome("cbbd"));
        System.out.println(s.longestPalindrome("abcda"));
        System.out.println(s.longestPalindrome("babadada"));
    }
}
