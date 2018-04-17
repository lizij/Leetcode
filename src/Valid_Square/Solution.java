package Valid_Square;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        /**
         * use diagonals to determine whether the four points is on a square
         * 17ms
         */
//        return isSquare(p1, p2, p3, p4) || isSquare(p1, p3, p2, p4) || isSquare(p1, p4, p2, p3);
        /**
         * calculate six lines between the four points. They will be on a square if four smaller lines are the same and two larger ones are the same
         * 21ms
         */
        Set<Integer> set = new HashSet<>(Arrays.asList(getLength(p1, p2), getLength(p1, p3), getLength(p1, p4), getLength(p2, p3), getLength(p2, p4), getLength(p3, p4)));
        return !set.contains(0) && set.size() == 2;
    }

    private boolean isSquare(int[] p1, int[] p2, int[] p3, int[] p4){
        int[] m1 = getMiddle(p1, p2);
        int[] m2 = getMiddle(p3, p4);
        return m1[0] == m2[0] && m1[1] == m2[1] && getLength(p1, p2) != 0 && getLength(p1, p2) == getLength(p3, p4) && isPerpendicular(p1, p2, p3, p4);
    }

    private int getLength(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    private int[] getMiddle(int[] p1, int[] p2){
        return new int[]{p1[0] + p2[0], p1[1] + p2[1]};
    }

    private int[] getAngle(int[] p1, int[] p2){
        return new int[]{p1[0] - p2[0], p1[1] - p2[1]};
    }

    private boolean isPerpendicular(int[] p1, int[] p2, int[] p3, int[] p4){
        int[] a1 = getAngle(p1, p2);
        int[] a2 = getAngle(p3, p4);
        return a1[0] * a2[0] + a1[1] * a2[1] == 0;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        System.out.println(s.validSquare(new int[]{0,0}, new int[]{0, 1}, new int[]{1, 0}, new int[]{1, 1}));
//        System.out.println(s.validSquare(new int[]{0,1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}));
//        System.out.println(s.isPerpendicular(new int[]{0,1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}));
//        System.out.println(s.validSquare(new int[]{-658,-2922}, new int[]{-965, -4209}, new int[]{-2252, -3902}, new int[]{-1945, -2615}));
        System.out.println(s.validSquare(new int[]{0,0}, new int[]{5,0}, new int[]{5,4}, new int[]{0,4}));
	}
}