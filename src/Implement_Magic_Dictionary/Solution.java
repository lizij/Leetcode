package Implement_Magic_Dictionary;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Solution{
    private MagicDictionary dictionary;
    public Solution(){
        dictionary = new MagicDictionary();
    }
    public class MagicDictionary {
        HashSet<String> set;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            set = new HashSet<>();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String s: dict) set.add(s);
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                if (diff(iterator.next(), word) == 1) return true;
            }
            return false;
        }

        private int diff(String a, String b){
            if (a.length() != b.length()) return -1;
            int count = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) count++;
            }
            return count;
        }
    }

    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dict);
     * boolean param_2 = obj.search(word);
     */
	public static void main(String[] args) {
		Solution s = new Solution();
		s.dictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(s.dictionary.search("hello"));
        System.out.println(s.dictionary.search("hhllo"));
        System.out.println(s.dictionary.search("hell"));
        System.out.println(s.dictionary.search("leetcoded"));
	}
}