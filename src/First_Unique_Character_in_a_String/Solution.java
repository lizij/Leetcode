package First_Unique_Character_in_a_String;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
//        HashMap<Character, Integer> map = new HashMap<>();
        int[] cmap = new int[26];
        for (int i = 0; i < s.length(); i++){
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            cmap[s.charAt(i) - 'a'] +=1;
        }
        for (int i = 0; i < s.length(); i++){
//            if (map.get(s.charAt(i)) == 1) return i;
            if (cmap[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.firstUniqChar("leetcode"));
        StdOut.println(s.firstUniqChar("loveleetcode"));
        StdOut.println(s.firstUniqChar(""));
        StdOut.println(s.firstUniqChar("dddccdbba"));
	}
}