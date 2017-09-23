package License_Key_Formatting;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder builder = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') continue;
            if (builder.length() % (K + 1) == K) builder.append('-');
            builder.append(S.charAt(i));
        }
        return builder.reverse().toString().toUpperCase();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.licenseKeyFormatting("2-4A0r7-4k", 4));
        StdOut.println(s.licenseKeyFormatting("2-4A0r7-4k", 3));
        StdOut.println(s.licenseKeyFormatting("--a-a-a-a--", 2));
	}
}