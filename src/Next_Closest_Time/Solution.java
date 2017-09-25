package Next_Closest_Time;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String nextClosestTime(String time) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < time.length(); i++) { set.add(time.charAt(i)); }
        String[] words = time.split(":");
        int minutes = Integer.parseInt(words[0]) * 60 + Integer.parseInt(words[1]) + 1;
        String res = minutesToString(minutes);
        while (!allCharInSet(set, res)){
            res = minutesToString(++minutes);
        }
        return res;
    }

    private boolean allCharInSet(Set<Character> set, String time){
        for (int i = 0; i < time.length(); i++) {
            if (!set.contains(time.charAt(i))) return false;
        }
        return true;
    }

    private String minutesToString(int minutes){
        int h = minutes / 60;
        int m = minutes % 60;
        if (h >= 24) h -= 24;
        return String.format("%02d:%02d", h, m);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		StdOut.println(s.nextClosestTime("19:34"));//19:39
		StdOut.println(s.nextClosestTime("23:59"));//22:22
	}
}