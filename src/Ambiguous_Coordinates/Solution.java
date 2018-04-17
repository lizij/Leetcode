package Ambiguous_Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> ambiguousCoordinates(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        /**
         * Brute force
         * 30ms
         */

        List<String> res = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            List<String> pre = getSub(s.substring(1, i));
            List<String> post = getSub(s.substring(i, s.length() - 1));
            for (String a: pre) {
                for (String b: post) {
                    res.add("(" + a + ", " + b + ")");
                }
            }
        }
        return res;
    }

    private List<String> getSub(String s) {
        /**
         * If s equals to, return
         * 1. "": []
         * 2. "0": [s]
         * 3. "0XX0": []
         * 4. "0XX": ["0.XX"]
         * 5. "XX0": [s]
         * 6. "XXX": [s, "X.XX", "XX.X"]
         */
        List<String> res = new ArrayList<>();

        int n = s.length();
        if (n == 0 || (n > 1 && s.charAt(0) == '0' && s.charAt(n - 1) == '0')) {
            return res;
        }

        if (n > 1 && s.charAt(0) == '0') {
            res.add("0." + s.substring(1));
            return res;
        }

        res.add(s);
        if (n == 1 || s.charAt(n - 1) == '0') {
            return res;
        }
        for (int i = 1; i < n; i++) {
            res.add(s.substring(0, i) + "." + s.substring(i));
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.ambiguousCoordinates("(123)")); // ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
		System.out.println(s.ambiguousCoordinates("(00011)")); // ["(0.001, 1)", "(0, 0.011)"]
		System.out.println(s.ambiguousCoordinates("(0123)")); // ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
		System.out.println(s.ambiguousCoordinates("(100)")); // [(10, 0)]
	}
}