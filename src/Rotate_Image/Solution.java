package Rotate_Image;



public class Solution {
    public void rotate(int[][] matrix) {
        rotate(matrix, 0, matrix.length - 1);
    }

    private void rotate(int[][] matrix, int lo, int hi){
        if (lo >= hi) return;
        for (int i = lo, tmp = 0; i < hi; i++) {
            tmp = matrix[lo][i];
            matrix[lo][i] = matrix[lo + hi - i][lo];
            matrix[lo + hi - i][lo] = matrix[hi][lo + hi - i];
            matrix[hi][lo + hi - i] = matrix[i][hi];
            matrix[i][hi] = tmp;
//            printMatrix(matrix);
        }
        rotate(matrix, lo + 1, hi - 1);
    }

    private void printMatrix(int[][] matrix){
        System.out.println("==========");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(String.format("%02d ", matrix[i][j]));
            }
            System.out.println();
        }
        System.out.println("==========");
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] input1 = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        s.rotate(input1);
        s.printMatrix(input1);
	}
}