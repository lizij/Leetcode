package Toeplitz_Matrix;
public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        /**
         * Judge if matrix[i][0...(n-2)] == matrix[i + 1][1...(n-1)]
         * 26ms
         */

        if (matrix.length == 1 || matrix[0].length == 1) {
            return true;
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            int[] cur = matrix[i];
            int[] next = matrix[i + 1];
            for (int j = 0; j < cur.length - 1; j++) {
                if (cur[j] != next[j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isToeplitzMatrix(new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        })); // true
		System.out.println(s.isToeplitzMatrix(new int[][]{
                {1, 2},
                {2, 2}
        })); // false
	}
}