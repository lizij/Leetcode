package Multiply_Strings;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String multiply(String num1, String num2) {
        /**
         * directly get product and add them in one iteration
         * 36ms
         */
        int[] pos = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + pos[i +j + 1];
                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i: pos) {
            if (!(builder.length() == 0 && i == 0)) builder.append(i);
        }
        return builder.length() == 0 ? "0" : builder.toString();

        /**
         * get product of every digit of num1 with num2, then sum them all.
         * 52ms
         */
//        List<String> results = new ArrayList<>();
//        for (int i = num1.length() - 1; i >= 0; i--) {
//            int digit = num1.charAt(i) - '0';
//            StringBuilder builder = new StringBuilder(multiply(num2, digit));
//            for (int j = 0; j < num1.length() - i - 1; j++) {
//                builder.append("0");
//            }
//            results.add(builder.toString());
//        }
//        String res = results.get(0);
//        for (int i = 1; i < results.size(); i++) {
//            res = add(res, results.get(i));
//        }
//        return res;
    }

    private String multiply(String a, int b) {
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            int val = (a.charAt(i) - '0') * b + carry;
            builder.append(val % 10);
            carry = val / 10;
        }
        if (carry > 0) builder.append(carry);
        while (builder.charAt(builder.length() - 1) == '0' && builder.length() > 1) builder.deleteCharAt(builder.length() - 1);
        return builder.reverse().toString();
    }

    private String add(String a, String b) {
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int val = (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0) + carry;
            builder.append(val % 10);
            carry = val / 10;
        }
        if (carry > 0) builder.append(carry);
        while (builder.charAt(builder.length() - 1) == '0' && builder.length() > 1) builder.deleteCharAt(builder.length() - 1);
        return builder.reverse().toString();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        StdOut.println(s.add("123", "987"));
//        StdOut.println(s.multiply("1234567", 11));
        StdOut.println(s.multiply("1234", "1111"));
        StdOut.println(s.multiply("9133", "0"));
	}
}