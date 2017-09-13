package Student_Attendance_Record_I;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean checkRecord(String s) {
//        String A = s.replace("A", "");
//        String L = s.replace("LLL", "");
//        return s.length() - A.length() <= 1 && s.length() == L.length();
        return !s.matches(".*LLL.*|.*A.*A.*");
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.checkRecord("PPALLP"));
        StdOut.println(s.checkRecord("PPALLL"));
        StdOut.println(s.checkRecord("LLLALL"));
	}
}