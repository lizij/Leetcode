package Count_Numbers_with_Unique_Digits;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    boolean[] marked;
    int count;
    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0) return -1;
        if (n > 10) return countNumbersWithUniqueDigits(10);
        marked = new boolean[10];
        count = 10;
        for (int i = 2; i <= n; i++) {
//            count(0, 0, i);
            count += count(0, i);
        }
        return count;
    }

    private int count(int cur, int n){
        if (cur == n) return 1;
        if (cur == 0) return 9 * count(cur + 1, n);
        else return (10 - cur) * count(cur + 1, n);
    }

//    private void count(int value, int cur, int n){
//        if (cur == n) count++;
//        for (int i = cur == 0 ? 1 : 0; i < 10; i++) {
//            if (!marked[i]){
//                marked[i] = true;
//                count(value * 10 + i, cur + 1, n);
//                marked[i] = false;
//            }
//        }
//    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.countNumbersWithUniqueDigits(2));
//        StdOut.println(s.countNumbersWithUniqueDigits(3));
	}
}