package Excel_Sheet_Column_Number;



public class Solution {
    public int titleToNumber(String s) {
        int n = 0;
        for (int i = 0; i < s.length();n = n * 26 + s.charAt(i) - 'A' + 1, i++);
        return n;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.titleToNumber("A"));
        System.out.println(s.titleToNumber("AA"));
        System.out.println(s.titleToNumber("BAZ"));
    }
}