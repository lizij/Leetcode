package Reverse_Words_in_a_String_III;



public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reverse = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            reverse.append(new StringBuffer(words[i]).reverse().toString() + " ");
        }
        return reverse.toString().trim();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "Let's take LeetCode contest";
        System.out.println(s.reverseWords(input));
    }
}
