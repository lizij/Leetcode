package Longest_Uncommon_Subsequence_I;



public class Solution {
    public int findLUSlength(String a, String b) {
//        String lcs = longestCommonSubsequence(a.toCharArray(), a.length() - 1, b.toCharArray(), b.length() - 1);
//        int lus = Math.max(a.length() - lcs.length(), b.length() - lcs.length());
//        return lus > 0 ? lus: -1;
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    private String longestCommonSubsequence(char[] a, int alen, char[] b, int blen){
        if (alen < 0 || blen < 0) return "";
        if (a[alen] == b[blen]) return longestCommonSubsequence(a, alen - 1, b, blen - 1) + a[alen];
        else{
            String one = longestCommonSubsequence(a, alen - 1, b, blen);
            String two = longestCommonSubsequence(a, alen, b, blen - 1);
            return one.length() > two.length()? one:two;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.findLUSlength("aba", "cdc"));
        String x = "aefawfawfawfaw", y = "aefawfeawfwafwaef";
        System.out.println(s.longestCommonSubsequence(x.toCharArray(), x.length() - 1, y.toCharArray(), y.length() - 1));
    }

}
