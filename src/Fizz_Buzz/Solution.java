package Fizz_Buzz;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0) builder.append("Fizz");
                if (i % 5 == 0) builder.append("Buzz");
            }
            else builder.append(String.valueOf(i));
            list.add(builder.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = s.fizzBuzz(15);
        for (String tmp: list.toArray(new String[list.size()])){
            StdOut.println(tmp);
        }
    }
}
