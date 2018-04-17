package Longest_Palindrome;



import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int res = 0, single = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 == 0) res+= value;
            else {
                res += value - 1;
                single++;
            }
        }
        return single > 0 ? res + 1 : res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.longestPalindrome("ccccdd"));
	}
}