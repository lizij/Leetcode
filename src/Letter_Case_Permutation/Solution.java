package Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return null;
        }

        /**
         * DFS
         * 12ms
         */

        List<String> res = new ArrayList<>();
        helper(S.toCharArray(), 0, res);
        return res;
    }

    private void helper(char[] str, int index, List<String> res) {
        if (index == str.length) {
            res.add(String.valueOf(str));
            return;
        }

        char c = str[index];
        if (Character.isLetter(c)) {
            str[index] = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
            helper(str, index + 1, res);
            str[index] = c;
        }

        helper(str, index + 1, res);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.letterCasePermutation("a1b2")); // ["a1b2", "a1B2", "A1b2", "A1B2"]
		System.out.println(s.letterCasePermutation("3z4")); // ["3z4", "3Z4"]
		System.out.println(s.letterCasePermutation("12345")); // ["12345"]
	}
}