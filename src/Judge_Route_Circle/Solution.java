package Judge_Route_Circle;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') y++;
            else if (c == 'D') y--;
            else if (c == 'L') x--;
            else if (c == 'R') x++;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        StdOut.println(s.judgeCircle("UD"));
        StdOut.println(s.judgeCircle("LL"));
    }
}
