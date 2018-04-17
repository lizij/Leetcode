package Reverse_String_II;



public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i+= 2 * k) {
            int lo = i;
            int hi = i + k - 1 <= s.length() - 1 ? i + k - 1 : s.length() - 1;
            while (lo < hi){
                char c = chars[lo];
                chars[lo] = chars[hi];
                chars[hi] = c;
                lo++;
                hi--;
            }
        }
        return new String(chars);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.reverseStr("abcdefg", 2));
        System.out.println(s.reverseStr("a", 2));
	}
}