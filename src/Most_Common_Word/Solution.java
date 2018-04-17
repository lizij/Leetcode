package Most_Common_Word;

import java.util.*;

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) {
            return null;
        }
        /**
         * Map solution
         * 28ms
         */

        Set<String> set = new HashSet<>();
        if (banned != null) {
            Collections.addAll(set, banned);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word: paragraph.toLowerCase().split("[ !?',;.]+")) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        String res = null;
        for (String k: map.keySet()) {
            if (res == null || map.get(k) > map.get(res)) {
                res = k;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"})); // ball
	}
}