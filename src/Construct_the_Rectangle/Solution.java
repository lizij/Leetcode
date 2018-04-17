package Construct_the_Rectangle;



public class Solution {
    public int[] constructRectangle(int area) {
        int root = (int)Math.ceil(Math.sqrt(area));
        while (area % root != 0) root++;
        return new int[]{root, area / root};
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] output1 = s.constructRectangle(6);
        System.out.println(output1[0] + "," + output1[1]);
	}
}