package Integer_Break;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int res = 1;
        while (n > 4){
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        for (int i = 2; i < 12; i++) StdOut.println(i + ":" + s.integerBreak(i));
	}
}