package Island_Perimeter;



public class Solution {
    public int islandPerimeter(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int peri = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1){
                    peri += 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) peri--;
                    if (i + 1 < N && grid[i + 1][j] == 1) peri--;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) peri--;
                    if (j + 1 < M && grid[i][j + 1] == 1) peri--;
                }
            }
        }
        return peri;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(s.islandPerimeter(input));
    }
}
