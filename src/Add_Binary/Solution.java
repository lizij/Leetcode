package Add_Binary;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int val = (i >= 0 ? Integer.parseInt(a.charAt(i) + "") : 0) + (j >= 0 ? Integer.parseInt(b.charAt(j) + "") : 0) + carry;
            builder.append(val % 2);
            carry = val / 2;
        }
        if (carry == 1) builder.append("1");
        return builder.reverse().toString();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.addBinary("11", "1"));
	}
}