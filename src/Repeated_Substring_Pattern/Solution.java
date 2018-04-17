package Repeated_Substring_Pattern;



public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) return false;
        /**
         * use every possible pattern to generate the whole string then compare it with s
         * 339ms
         */
//        String pattern;
//        for (int i = 1; i <= s.length() / 2; i++) {
//             pattern = s.substring(0, i);
//             if (s.length() % pattern.length() == 0) {
//                 StringBuilder builder = new StringBuilder();
//                 for (int j = 0; j < s.length() / pattern.length(); j++) {
//                     builder.append(pattern);
//                 }
//                 if (s.equals(builder.toString())) return true;
//             }
//        }
//        return false;
        /**
         * Get ss: concat s with itself then remove the first and the last char of it.
         * If s is constructed with pattern like "p", s will be like "pppp". ss will be "xppppppx", in which x represents the broken pattern
         * If s is not constructed with any pattern. None of any part inside s can both be its head and tail
         * 58ms
         */
//        return (s.substring(1, s.length()) + s.substring(0, s.length() - 1)).contains(s);

        /**
         * kmp solution
         *
         */
        int[] prefix = kmp(s);
        int n = s.length();
        return prefix[n - 1] > 0 && n % (n - prefix[n - 1]) == 0;
    }

    private int[] kmp(String s) {
        int n = s.length();
        int[] res = new int[n];
        for (int i = 0, j = 1; i < n && j < n;) {
            if (s.charAt(j) == s.charAt(i)) {
                res[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    res[j] = 0;
                    j++;
                } else {
                    i = res[i - 1];
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.repeatedSubstringPattern("abab"));//true
        System.out.println(s.repeatedSubstringPattern("aba"));//false
        System.out.println(s.repeatedSubstringPattern("abcabcabcabc"));//true
	}
}