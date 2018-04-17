package Decode_String;


import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0, num = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if (c == '['){
                nums.push(num);
                num = 0;
                strs.push("");
            }
            else if (c == ']'){
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < nums.peek(); j++) {
                    builder.append(strs.peek());
                }
                nums.pop();
                strs.pop();
                if (nums.size() == 0) {
                    res.append(builder.toString());
                }
                else{
                    strs.push(strs.pop() + builder.toString());
                }
            }
            else{
                if (nums.size() > 0) strs.push(strs.pop() + c);
                else res.append(c);
            }
        }
        return res.toString();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.decodeString("3[a]2[bc]"));//aaabcbc
        System.out.println(s.decodeString("3[a2[c]]"));//accaccacc
        System.out.println(s.decodeString("2[abc]3[cd]ef"));//abcabccdcdcdef
        System.out.println(s.decodeString("2[2[b]]"));//bbbb
	}
}