package Student_Attendance_Record_I;



public class Solution {
    public boolean checkRecord(String s) {
//        String A = s.replace("A", "");
//        String L = s.replace("LLL", "");
//        return s.length() - A.length() <= 1 && s.length() == L.length();
        return !s.matches(".*LLL.*|.*A.*A.*");
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.checkRecord("PPALLP"));
        System.out.println(s.checkRecord("PPALLL"));
        System.out.println(s.checkRecord("LLLALL"));
	}
}