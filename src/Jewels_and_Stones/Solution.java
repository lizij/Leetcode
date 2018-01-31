package Jewels_and_Stones;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        /**
         * Set solution
         * 28ms
         */

        Set<Character> set = new HashSet<>();
        for (char j: J.toCharArray()) {
            set.add(j);
        }

        int res = 0;
        for (char s: S.toCharArray()) {
            if (set.contains(s)) {
                res++;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numJewelsInStones("aA", "aAAbbbb")); // 3
		System.out.println(s.numJewelsInStones("z", "ZZ")); // 0
	}
}