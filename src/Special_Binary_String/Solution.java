package Special_Binary_String;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String makeLargestSpecial(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        /**
         * Sort solution
         * Two key points:
         * 1. split s as many as possible
         * 2. a special string should start with '1' and end with '0' like "1M0", with M is also a special string
         * 15ms
         */

        List<String> specials = new ArrayList<>();
        int count = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                specials.add('1' + makeLargestSpecial(s.substring(j + 1, i)) + '0');
                j = i + 1;
            }
        }

        specials.sort(Comparator.reverseOrder());

        return String.join("", specials);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(s.makeLargestSpecial("11011000")); // "11100100"
		System.out.println(s.makeLargestSpecial("101101011000")); // "111001010010"
	}
}