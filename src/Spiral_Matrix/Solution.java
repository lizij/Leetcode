package Spiral_Matrix;



import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] marked = new boolean[m][n];
        int i = 0, j = 0, count = 1;
        List<Integer> res = new ArrayList<>();
        while (count <= m * n){
            while (j < n && !marked[i][j] && count <= m * n){ marked[i][j] = true;res.add(matrix[i][j++]);count++; }
            i++;j--;
            while (i < m && !marked[i][j] && count <= m * n) { marked[i][j] = true;res.add(matrix[i++][j]);count++; }
            i--;j--;
            while (j >= 0 && !marked[i][j] && count <= m * n){ marked[i][j] = true;res.add(matrix[i][j--]);count++; }
            i--;j++;
            while (i >= 0 && !marked[i][j] && count <= m * n){ marked[i][j] = true;res.add(matrix[i--][j]);count++; }
            i++;j++;
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        List<Integer> output1 = s.spiralOrder(new int[][]{
//                { 1, 2, 3, 4},
//                {12,13,14, 5},
//                {11,16,15, 6},
//                {10, 9, 8, 7}});
//        for (int i: output1) System.out.print(i + " ");
        List<Integer> output1 = s.spiralOrder(new int[][]{});
        for (int i: output1) System.out.print(i + " ");
	}
}