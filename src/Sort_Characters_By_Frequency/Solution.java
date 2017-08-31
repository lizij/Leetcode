package Sort_Characters_By_Frequency;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getValue(); j++) {
                builder.append(list.get(i).getKey());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        StdOut.println(s.frequencySort("tree"));
        StdOut.println(s.frequencySort("cccaaa"));
        StdOut.println(s.frequencySort("Aabb"));
    }
}
