package Happy_Number;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = digitsSquareSum(n);
        while (!set.contains(sum)){
            if (sum == 1) return true;
            set.add(sum);
            sum = digitsSquareSum(sum);
        }
        return false;
    }

    private int digitsSquareSum(int n){
        int sum = 0;
        while (n > 0){
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.isHappy(19));
        StdOut.println(s.isHappy(4));
        StdOut.println(s.isHappy(987654321));
	}
}