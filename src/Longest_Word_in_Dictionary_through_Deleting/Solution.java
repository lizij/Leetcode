package Longest_Word_in_Dictionary_through_Deleting;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        int index = -1;
        for (int i = d.size() - 1; i >= 0; i--) {
            String tmp = d.get(i);
            if (isSubSequence(tmp, s)){
                if (index == -1 || tmp.length() > d.get(index).length() || (tmp.length() == d.get(index).length() && tmp.compareTo(d.get(index)) < 0)) index = i;
            }
        }
        return index != -1?d.get(index):"";
    }

    private boolean isSubSequence(String a, String b){// a is a subsequence of b
        for (int i = 0, j = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if ((j = b.indexOf(c, j)) < 0) return false;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> input1 = new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        List<String> input2 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<String> input3 = new ArrayList<>(Arrays.asList("ba", "ab", "a", "b"));
        System.out.println(s.findLongestWord("abpcplea", input1));
        System.out.println(s.findLongestWord("abpcplea", input2));
        System.out.println(s.findLongestWord("bab", input3));
    }
}
