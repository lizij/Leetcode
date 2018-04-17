package Reshape_the_Matrix;



public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int N = nums.length, M = nums[0].length;
        if (N * M != r * c) return nums;
        int[][] re = new int[r][c];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                re[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = {{1, 2}, {3, 4}};
        int[][] input2 = {{1, 2, 3, 4}};
        int[][] re1 = s.matrixReshape(input, 1, 4);
        int[][] re2 = s.matrixReshape(input, 2, 4);
        int[][] re3 = s.matrixReshape(input2, 2, 2);

        System.out.println(re1.length == 1 && re1[0].length == 4);
        System.out.println(re2.length == 2 && re2[0].length == 4);
        System.out.println(re3.length == 2 && re3[0].length == 2);
    }
}
