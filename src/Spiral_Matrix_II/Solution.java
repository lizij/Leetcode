package Spiral_Matrix_II;



public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0, j = 0, count = 1;
        while (count <= n * n){
            while (j < n && res[i][j] == 0 && count <= n * n) { res[i][j++] = count++; }
            i++;j--;
            while (i < n && res[i][j] == 0 && count <= n * n) { res[i++][j] = count++; }
            i--;j--;
            while (j >= 0 && res[i][j] == 0 && count <= n * n){ res[i][j--] = count++; }
            i--;j++;
            while (i >= 0 && res[i][j] == 0 && count <= n * n){ res[i--][j] = count++; }
            i++;j++;
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        int[][] output1 = s.generateMatrix(4);
        for (int[] line: output1){
            for (int i: line) System.out.print(i + " ");
            System.out.println();
        }
	}
}