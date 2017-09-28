package Search_a_2D_Matrix;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * treat this matrix as a sorted list and use binary search
         * 1ms
         */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target) return true;
            if (val < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] input1 = new int[][]{
            { 1, 3, 5, 7},
            {10,11,16,20},
            {23,30,34,50}
        };
        StdOut.println(s.searchMatrix(input1, 3));
        StdOut.println(s.searchMatrix(input1, 16));
        StdOut.println(s.searchMatrix(input1, 23));
        StdOut.println(s.searchMatrix(input1, 24));
	}
}