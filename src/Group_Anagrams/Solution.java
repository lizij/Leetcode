package Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        /**
         * Use RadixSort to get sorted version of every string
         * Use Map to partition strings by their sorted versions
         * Because I use RadixSort, the final time complexity is O(n * k), k is the longest string's length
         * 27ms
         */

        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            String sorted = sort(s);
            List<String> list = map.getOrDefault(sorted, new ArrayList<>());
            list.add(s);
            map.put(sorted, list);
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String s) {
        // radix sort
        int[] letters = new int[26];
        char[] chs = s.toCharArray();
        for (char c: chs) {
            letters[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i]; j++) {
                builder.append((char) (i + 'a'));
            }
        }
        return builder.toString();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
}