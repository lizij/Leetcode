package Rotate_String;
public class Solution {
    public boolean rotateString(String A, String B) {
        return (A + A).contains(B);
    }
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}