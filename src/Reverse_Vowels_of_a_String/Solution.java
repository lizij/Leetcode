package Reverse_Vowels_of_a_String;



import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return "";
        /**
         * use Set
         * 12ms
         */
        Set<Character> set = new HashSet<Character>(){{
            add('a');add('e');add('i');add('o');add('u');
            add('A');add('E');add('I');add('O');add('U');
        }};
        char[] chars = s.toCharArray();
        int lo = -1, hi = s.length();
        while (true){
            while (++lo < s.length() && !set.contains(chars[lo]));
            while (--hi >= 0 && !set.contains(chars[hi]));
            if (lo >= hi) break;
            char tmp = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = tmp;
        }
        return new String(chars);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.reverseVowels("hello"));//holle
        System.out.println(s.reverseVowels("leetcode"));//leotcede
        System.out.println(s.reverseVowels("l"));
        System.out.println(s.reverseVowels(""));
        System.out.println(s.reverseVowels("aA"));
	}
}