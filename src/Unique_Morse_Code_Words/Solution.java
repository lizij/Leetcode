package Unique_Morse_Code_Words;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        /**
         * Set solution
         * 10ms
         */

        String[] dict = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String w: words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < w.length(); i++) {
                builder.append(dict[w.charAt(i) - 'a']);
            }
            set.add(builder.toString());
        }

        return set.size();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
	}
}