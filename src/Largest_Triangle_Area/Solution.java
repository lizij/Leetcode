package Largest_Triangle_Area;
public class Solution {
    public double largestTriangleArea(int[][] points) {
        if (points == null || points.length < 3 || points[0].length != 2) {
            return 0;
        }
        /**
         * Brute force
         * 30ms
         */

        int n = points.length;
        double res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    res = Math.max(res, getArea(new int[]{points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]}));
                }
            }
        }
        return res;
    }

    private double getArea(int[] points){
        if (points.length != 6) {
            return 0;
        }

        double a = getLength(points[0], points[1], points[2], points[3]);
        double b = getLength(points[0], points[1], points[4], points[5]);
        double c = getLength(points[2], points[3], points[4], points[5]);
        if (a + b > c && a + c > b && b + c > a) {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else {
            return 0;
        }
    }

    private double getLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}})); // 2
		System.out.println(s.largestTriangleArea(new int[][]{{35,-23},{-12,-48},{-34,-40},{21,-25},{-35,-44},{24,1},{16,-9},{41,4},{-36,-49},{42,-49},{-37,-20},{-35,11},{-2,-36},{18,21},{18,8},{-24,14},{-23,-11},{-8,44},{-19,-3},{0,-10},{-21,-4},{23,18},{20,11},{-42,24},{6,-19}})); // 3627
//		System.out.println(s.largestTriangleArea(new int[][]{{-19,-3},{-21,-4},{23,18}})); // 3627
	}
}