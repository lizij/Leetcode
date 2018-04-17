package Is_Subsequence;



public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        for (int i = 0, pos = 0; i < t.length(); i++) {
            if (s.charAt(pos) == t.charAt(i)) pos++;
            if (pos == s.length()) return true;
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
        System.out.println(s.isSubsequence("ace", "abcde"));
        System.out.println(s.isSubsequence("aec", "abcde"));
	}
}