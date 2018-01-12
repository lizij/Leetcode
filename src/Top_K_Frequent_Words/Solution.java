package Top_K_Frequent_Words;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        /**
         * Use Map to get frequency of each word
         * Use PriorityQueue to get the k largest frequency of words
         * 102ms
         */
        if (words == null || words.length == 0 || k <= 0) {
            return null;
        }

        Map<String, Integer> freq = new HashMap<>();
        for (String w: words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (o1, o2) -> o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue()
        );

        queue.addAll(freq.entrySet());

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.poll().getKey());
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2)); // ["i", "love"]
		System.out.println(s.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4)); // ["the", "is", "sunny", "day"]
	}
}