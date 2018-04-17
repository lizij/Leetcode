package Keyboard_Row;



import java.util.ArrayList;

public class Solution {
    public String[] findWords(String[] words) {
        String ROW1 = "qwertyuiop";
        String ROW2 = "asdfghjkl";
        String ROW3 = "zxcvbnm";
        ArrayList<String> list = new ArrayList<>();
        for (String word: words){
            if (inOneRow(word, ROW1) || inOneRow(word, ROW2) || inOneRow(word, ROW3)) list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }

    private boolean inOneRow(String word, String row){
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!row.contains(c + "")) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] input = {"Hello", "Alaska", "Dad", "Peace"};
        for (String word: s.findWords(input)){
            System.out.print(word + " ");
        }
    }
}
