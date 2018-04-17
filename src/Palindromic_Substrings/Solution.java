package Palindromic_Substrings;



import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int countSubstrings(String s) {
//        int count = s.length();
//        for (int i = 0; i < s.length() - 1; i++) {
//            for (int j = i + 2; j < s.length() + 1; j++) {
//                if (isPalindromic(s.substring(i, j))) count++;
//            }
//        }
//        return count;
        int N = s.length();
//        System.out.println(s);
        if (N <= 1) return N;
        if (s.charAt(0) == s.charAt(N - 1)){
//            System.out.println(s + " = " + s.substring(0, N - 1) + " + " + s.substring(1, N) + " - " + s.substring(1, N - 1) + " + 1");
            return countSubstrings(s.substring(0, N - 1)) + countSubstrings(s.substring(1, N)) - countSubstrings(s.substring(1, N - 1)) + 1;
        }
        else{
//            System.out.println(s + " = " + s.substring(0, N - 1) + " + " + s.substring(1, N) + " - " + s.substring(1, N - 1));
            return countSubstrings(s.substring(0, N - 1)) + countSubstrings(s.substring(1, N)) - countSubstrings(s.substring(1, N - 1));
        }
    }

    private boolean isPalindromic(String s){
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String input1 = "abc";
//        String input2 = "aaa";
        System.out.println(s.countSubstrings("abc"));
        System.out.println(s.countSubstrings("aaa"));
        System.out.println(s.countSubstrings("fdsklf"));
    }
}
