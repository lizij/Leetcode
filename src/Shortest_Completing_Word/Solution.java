package Shortest_Completing_Word;

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] dict = new int[26];
        String lowerCaseLicensePlate = licensePlate.toLowerCase();
        for (int i = 0; i < lowerCaseLicensePlate.length(); i++) {
            char c = lowerCaseLicensePlate.charAt(i);
            if (Character.isLetter(c)) {
                dict[c - 'a']++;
            }
        }

        String res = null;
        for (int i = 0; i < words.length; i++) {
            if ((res == null || words[i].length() < res.length()) && canComplete(words[i], dict)) {
                res = words[i];
            }

        }
        return res;
    }

    private boolean canComplete(String str, int[] dict) {
        int[] letters = getLetters(str);
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] < dict[i]) return false;
        }
        return true;
    }

    private int[] getLetters(String str) {
        String lowerCase = str.toLowerCase();
        int[] letters = new int[26];
        for (int i = 0; i < lowerCase.length(); i++) {
            letters[lowerCase.charAt(i) - 'a']++;
        }
        return letters;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"})); // steps
        System.out.println(s.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"})); // pest
    }
}
