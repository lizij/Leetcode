package Search_a_2D_Matrix_II;



public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        /**
         * scan every possible row and use binary search
         * 15ms
         */
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][0] <= target && matrix[i][n - 1] >= target && binarySearch(matrix, i, target)) return true;
//        }
        /**
         * use properties of this matrix, traverse from top right to bottom left.
         * 19ms
         */
        for (int row = 0, col = n - 1; row < m && col >= 0;) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int row, int target) {
        int lo = 0, hi = matrix[row].length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int val = matrix[row][mid];
            if (val == target) return true;
            else if (target < val) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] input1 = new int[][]{
		        {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(s.searchMatrix(input1, 5));
        System.out.println(s.searchMatrix(input1, 20));
	}
}