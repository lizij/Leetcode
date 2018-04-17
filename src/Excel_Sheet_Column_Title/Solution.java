package Excel_Sheet_Column_Title;



public class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + n % 26);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        for (int i = 1; i < 30; i++) {
            System.out.println(i + ":" + s.convertToTitle(i));
        }
    }
}