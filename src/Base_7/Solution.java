package Base_7;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public String convertToBase7(int num) {
//        if (num < 0) return "-" + convert(0 - num);
//        if (num == 0) return "0";
//        return convert(num);
        return Integer.toString(Integer.parseInt(num+"", 10), 7);
    }

    private String convert(int num){
        if (num < 0) return "-" + convert(0 - num);
        return num == 0 ? "" : convert(num / 7) + num % 7;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.convertToBase7(100));
        StdOut.println(s.convertToBase7(-7));
        StdOut.println(s.convertToBase7(0));
	}
}