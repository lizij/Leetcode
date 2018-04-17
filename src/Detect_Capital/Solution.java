package Detect_Capital;



import java.util.regex.Pattern;

public class Solution {
    public boolean detectCapitalUse(String word) {
        Pattern pattern = Pattern.compile("[A-Z]+|[a-z]+|[A-Z][a-z]+");
        return pattern.matcher(word).matches();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.detectCapitalUse("USA"));
        System.out.println(s.detectCapitalUse("usa"));
        System.out.println(s.detectCapitalUse("Usa"));
        System.out.println(s.detectCapitalUse("FlaG"));
        System.out.println(s.detectCapitalUse("fLAg"));
    }
}
