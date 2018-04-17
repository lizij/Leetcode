package Maximum_Product_of_Word_Lengths;



public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int N = words.length;
        int[] mask = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((mask[i] & mask[j]) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(s.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(s.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
	}
}