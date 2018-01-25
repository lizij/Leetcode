package Palindrome_Pairs;

import java.util.*;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        int n = words.length;
        List<List<Integer>> res = new ArrayList<>();

        /**
         * Brute force: Try every pair of (i, j) if it is a palindrome string
         * TLE 73/134
         */
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                String pair1 = words[i] + words[j];
//                String pair2 = words[j] + words[i];
//                if (isPalindrome(pair1, 0, pair1.length())) {
//                    res.add(Arrays.asList(i, j));
//                }
//
//                if (isPalindrome(pair2, 0, pair2.length())) {
//                    res.add(Arrays.asList(j, i));
//                }
//            }
//        }

        /**
         * Trie solution:Use Trie to narrow down the list
         * For words[i], we insert it into the Trie reversely,
         * and when we find one of its prefix is palindrome,
         * add it to the list.
         * Then for words[i], we start to find every possible result
         * eg. We store "ba" as "ab" into the Trie
         * when we find pair for "a", we can find "ab" -> "ba"
         * which has a palindrome prefix "b",
         * then we add [index("a"), index("ba")] into result
         * 116ms
         */

        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(words[i], i);
        }

        for (int i = 0; i < n; i++) {
            List<List<Integer>> tmp = trie.search(words[i], i);
            res.addAll(tmp);
        }

        return res;
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }
        }
        return true;
    }



    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s, int index) {
            TrieNode cur = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (!cur.next.containsKey(c)) {
                    cur.next.put(c, new TrieNode());
                }

                if (isPalindrome(s, 0, i)) {
                    cur.list.add(index);
                }
                cur = cur.next.get(c);
            }
            cur.list.add(index);
            cur.index = index;
        }

        public List<List<Integer>> search(String s, int index) {
            if (s == null) {
                return null;
            }

            TrieNode cur = root;
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (cur.index >= 0 && cur.index != index && isPalindrome(s, i, s.length() - 1)) {
                    res.add(Arrays.asList(index, cur.index));
                }

                if (!cur.next.containsKey(s.charAt(i))) {
                    return res;
                }
                cur = cur.next.get(s.charAt(i));
            }

            for (int i: cur.list) {
                if (index == i) {
                    continue;
                }
                res.add(Arrays.asList(index, i));
            }
            return res;
        }

        class TrieNode {
            int index;
            List<Integer> list;
            Map<Character, TrieNode> next;

            public TrieNode() {
                index = -1;
                list = new ArrayList<>();
                next = new HashMap<>();
            }
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.palindromePairs(new String[]{"bat", "tab", "cat"})); // [[0, 1], [1, 0]]
		System.out.println(s.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"})); // [[0, 1], [1, 0], [3, 2], [2, 4]]
	}
}