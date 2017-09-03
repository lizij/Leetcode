package Ransom_Note;

import java.util.HashMap;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: magazine.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c: ransomNote.toCharArray()){
            int left = map.getOrDefault(c, 0);
            if (left == 0) return false;
            map.put(c, left - 1);
        }
        return true;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}