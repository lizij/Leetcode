package Convert_a_Number_to_Hexadecimal;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] hexs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder res = new StringBuilder();
        while (num != 0){
            res.insert(0, hexs[num & 15]);
            num = num >>> 4;
        }
        return res.toString();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.toHex(26));
        StdOut.println(s.toHex(-1));
	}
}