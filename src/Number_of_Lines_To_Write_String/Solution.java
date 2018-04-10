package Number_of_Lines_To_Write_String;

import java.util.Arrays;

public class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        /**
         * Count solution
         * 3ms
         */
        int line = 1, units = 0;
        for (char c: s.toCharArray()) {
            if (units + widths[c - 'a'] <= 100) {
                units += widths[c - 'a'];
            } else {
                line++;
                units = widths[c - 'a'];
            }
        }

        return new int[]{line, units};
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.numberOfLines(new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "abcdefghijklmnopqrstuvwxyz"))); // [3, 60]
		System.out.println(Arrays.toString(s.numberOfLines(new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "bbbcccdddaaa"))); // [2, 4]
	}
}