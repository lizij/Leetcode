package Add_Strings;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int pos1, pos2;
        boolean carry = false;
        for (pos1 = num1.length() - 1, pos2 = num2.length() - 1; pos1 >= 0 || pos2 >= 0 ;pos1--, pos2--) {
            int val = (pos1 >= 0 ? num1.charAt(pos1) - '0' : 0) + (pos2 >= 0 ? num2.charAt(pos2) - '0' : 0);
            if (carry){
                val += 1;
                carry = false;
            }

            if (val >= 10){
                val -= 10;
                carry = true;
            }

            builder.append(val);
        }
        if (carry) builder.append(1);
        return builder.reverse().toString();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.addStrings("1234", "567"));
        StdOut.println(s.addStrings("9999", "1"));
        StdOut.println(s.addStrings("0", "0"));
	}
}