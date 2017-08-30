package Detect_Capital;

import edu.princeton.cs.algs4.StdOut;

import java.util.regex.Pattern;

public class Solution {
    public boolean detectCapitalUse(String word) {
        Pattern pattern = Pattern.compile("[A-Z]+|[a-z]+|[A-Z][a-z]+");
        return pattern.matcher(word).matches();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        StdOut.println(s.detectCapitalUse("USA"));
        StdOut.println(s.detectCapitalUse("usa"));
        StdOut.println(s.detectCapitalUse("Usa"));
        StdOut.println(s.detectCapitalUse("FlaG"));
        StdOut.println(s.detectCapitalUse("fLAg"));
    }
}
