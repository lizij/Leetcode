package Longest_Word_in_Dictionary;

import java.util.*;

public class Solution {
    public String longestWord(String[] words) {
        /**
         * Use PriorityQueue to store all words and poll longer words priorly
         * Check if all prefixes of a word is in the queue
         * 125ms
         */
//        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length());
//        queue.addAll(Arrays.asList(words));
//        while (!queue.isEmpty()) {
//            String word = queue.poll();
//            boolean isRes = true;
//            for (int i = 1; i < word.length(); i++) {
//                if (!queue.contains(word.substring(0, i))) {
//                    isRes = false;
//                    break;
//                }
//            }
//            if (isRes) {
//                return word;
//            }
//        }
//        return null;

        /**
         * Use TrieTree to store all words then use DFS to find the answer
         * 93ms
         */
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }

        String res = "";
        Stack<Node> stack = new Stack<>();
        stack.push(trie.root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.end >= 0 || node == trie.root) {
                if (node != trie.root) {
                    String word = trie.words.get(node.end);
                    if (word.length() > res.length() || word.length() == res.length() && word.compareTo(res) < 0) {
                        res = word;
                    }
                }
                for (Node n: node.children.values()) {
                    stack.push(n);
                }
            }
        }
        return res;
    }

    class Node {
        char c;
        HashMap<Character, Node> children;
        int end; // the index of the string ending with this

        public Node(char c) {
            this.c = c;
            children = new HashMap<>();
            end = -1;
        }
    }

    class Trie {

        Node root;
        List<String> words;

        public Trie() {
            // start with '\0' node
            root = new Node('\0');
            words = new ArrayList<>();
        }

        public void insert(String word) {
            if (contains(word)) {
                return;
            }
            // from root to set each child in their position
            Node cur = root;
            for (char c: word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            words.add(word);
            cur.end = words.size() - 1;
        }

        public boolean contains(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            Node cur = root;
            for (char c: word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
            return cur.end >= 0;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestWord(new String[]{"w","wo","wor","worl", "world"})); // world
		System.out.println(s.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})); // apple
		System.out.println(s.longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"})); // yodn
		System.out.println(s.longestWord(new String[]{"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"})); // mocha
		System.out.println(s.longestWord(new String[]{"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"})); // otif
	}
}