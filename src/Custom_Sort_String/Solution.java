package Custom_Sort_String;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0 || T == null) {
            return null;
        }

        /**
         * Bucket sort
         * 4ms
         */

        int[] count = new int[26];
        for (char c: T.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder builder = new StringBuilder();
        for (char c: S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; i++) {
                builder.append(c);
            }
            count[c - 'a'] = 0;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < count[c - 'a']; i++) {
                builder.append(c);
            }
        }

        return builder.toString();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.customSortString("cba", "abcd")); // cbad
	}
}