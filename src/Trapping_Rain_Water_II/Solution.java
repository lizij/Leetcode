package Trapping_Rain_Water_II;



import java.util.PriorityQueue;

public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>();

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] marked = new boolean[m][n];

        //Add borders
        for (int i = 0; i < m; i++) {
            marked[i][0] = true;
            marked[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 1; i < n - 1; i++) {
            marked[0][i] = true;
            marked[m - 1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        // from the borders, pick shortest cell marked and check its neighbors
        // if the neighbor is shorter, collect the water it can trap
        // and update its height as its height plus the water trapped
        // add all its neighbors to the queue
        int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] neighbor: neighbors) {
                int row = cell.row + neighbor[0];
                int col = cell.col + neighbor[1];
                if (isValid(row, col, m, n) && !marked[row][col]) {
                    marked[row][col] = true;
                    res += Math.max(0, cell.height - heightMap[row][col]);
                    queue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
                }
            }
        }
        return res;
    }

    boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    class Cell implements Comparable<Cell>{
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Cell o) {
            return height - o.height;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d):%d", row, col, height);
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.trapRainWater(new int[][]{
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        }));//4
	}
}