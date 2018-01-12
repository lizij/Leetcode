package Contain_Virus;

import java.util.*;

public class Solution {
    Set<Integer> visited;
    List<Set<Integer>> areas;
    List<Set<Integer>> adjacents;
    List<Integer> walls;
    int[][] grid;
    int R, C;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int containVirus(int[][] grid) {
        /**
         * AC solution
         * 41ms
         */
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;

        int res = 0;
        while (true) {
            visited = new HashSet<>();
            areas = new ArrayList<>();
            adjacents = new ArrayList<>();
            walls = new ArrayList<>();

            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    if (grid[r][c] == 1 && !visited.contains(r*C + c)) {
                        areas.add(new HashSet<>());
                        adjacents.add(new HashSet<>());
                        walls.add(0);
                        dfs(r, c);
                    }
                }
            }

            if (areas.isEmpty()) break;
            int maxAdjacentIndex = 0;
            for (int i = 0; i < adjacents.size(); ++i) {
                if (adjacents.get(maxAdjacentIndex).size() < adjacents.get(i).size())
                    maxAdjacentIndex = i;
            }

            res += walls.get(maxAdjacentIndex);

            for (int i = 0; i < areas.size(); ++i) {
                if (i == maxAdjacentIndex) {
                    for (int code: areas.get(i))
                        grid[code / C][code % C] = 2;
                } else {
                    spread(areas.get(i));
                }
            }
        }
        return res;
    }

    private void spread(Set<Integer> area) {
        for (int code: area) {
            int r = code / C, c = code % C;
            for (int[] d: directions) {
                int x = r + d[0], y = c + d[1];
                if (isValid(x, y) && grid[x][y] == 0)
                    grid[x][y] = 1;
            }
        }
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    public void dfs(int r, int c) {
        if (!visited.contains(r*C + c)) {
            visited.add(r*C + c);
            int N = areas.size();
            areas.get(N - 1).add(r*C + c);
            for (int[] d: directions) {
                int x = r + d[0], y = c + d[1];
                if (isValid(x, y)) {
                    if (grid[x][y] == 1) {
                        dfs(x, y);
                    } else if (grid[x][y] == 0){
                        adjacents.get(N - 1).add(x*C + y);
                        walls.set(N - 1, walls.get(N - 1) + 1);
                    }
                }
            }
        }
    }

//    private boolean DEBUG = true;
//    private int[][] grid; // 0 for unaffected, 1 for affected, 2 for blocked
//    private int m;
//    private int n;
//    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//    public int containVirus(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        this.grid = grid;
//        m = grid.length;
//        n = grid[0].length;
//
//        List<List<int[]>> affectedAreas = getAffectedAreas();
//        int res = 0;
//        if (DEBUG) {
//            printGrid();
//        }
//
//        /**
//         * My idea should be the same as the AC solution. The steps are shown below.
//         * 1. Get all affected areas in the grid. If there are still affected areas, go to the following steps
//         * 2. Get all adjacent unaffected cells of each area and find the max one. Add it to result
//         * 3. Block the area which need the most walls (change all cells' value in the area to 2)
//         * 4. Spread other areas.
//         * 96ms
//         */
//        while (affectedAreas.size() > 0) {
//            // get adjacent cells of each area
//            int maxAdjacents = 0;
//            List<List<int[]>> adjacentList = new ArrayList<>();
//            for (int i = 0; i < affectedAreas.size(); i++) {
//                List<int[]> adjacent = getAdjacentUnaffectedCells(affectedAreas.get(i));
//                adjacentList.add(adjacent);
//                if (adjacent.size() > adjacentList.get(maxAdjacents).size()) {
//                    maxAdjacents = i;
//                }
//            }
//
//            // spread other areas
//            for (int i = 0; i < affectedAreas.size(); i++) {
//                if (i == maxAdjacents) {
//                    // disable this area
//                    res += wallsNeed(affectedAreas.get(i), adjacentList.get(i));
//                    for (int[] cell: affectedAreas.get(i)) {
//                        this.grid[cell[0]][cell[1]] = 2;
//                    }
//                } else {
//                    spread(affectedAreas.get(i), adjacentList.get(i));
//                }
//            }
//
//            if (DEBUG) {
//                printGrid();
//            }
//            // refresh affected areas
//            affectedAreas = getAffectedAreas();
//        }
//        return res;
//    }
//
//    private int wallsNeed(List<int[]> affectedArea, List<int[]> adjacentCells) {
//        // get the number of walls needed by affectedArea
//        int res = 0;
//        boolean[][] visited = new boolean[m][n];
//        for (int[] cell: affectedArea) {
//            visited[cell[0]][cell[1]] = true;
//        }
//        for (int[] cell: adjacentCells) {
//            for (int[] d: directions) {
//                int x = cell[0] + d[0];
//                int y = cell[1] + d[1];
//                if (isValid(x, y) && visited[x][y]) {
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
//
//    private void printGrid() {
//        for (int[] row: grid) {
//            System.out.println(Arrays.toString(row));
//        }
//        System.out.println();
//    }
//
//    private void spreadTest(List<List<int[]>> affectedAreas) {
//        System.out.println("Before spread");
//        printGrid();
//        for (List<int[]> area: affectedAreas) {
//            List<int[]> adjacentCells = getAdjacentUnaffectedCells(area);
//            spread(area, adjacentCells);
//        }
//        System.out.println("After spread");
//        printGrid();
//    }
//
//    private List<List<int[]>> getAffectedAreas() {
//        List<List<int[]>> res = new ArrayList<>();
//        boolean[][] visited = new boolean[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] != 1 || visited[i][j]) {
//                    continue;
//                }
//                List<int[]> area = new ArrayList<>();
//                dfs(i, j, area, visited);
//                res.add(area);
//            }
//        }
//        return res;
//    }
//
//    private void dfs(int i, int j, List<int[]> area, boolean[][] visited) {
//        // find affected cells towards right and down
//        if (!isValid(i, j) || grid[i][j] == 0) {
//            return;
//        }
//        visited[i][j] = true;
//        area.add(new int[]{i, j});
//        Stack<int[]> stack = new Stack<>();
//        stack.push(new int[]{i, j});
//        while (!stack.isEmpty()) {
//            int[] p = stack.pop();
//            visited[p[0]][p[1]] = true;
//            area.add(p);
//            for (int[] d: directions) {
//                int x = p[0] + d[0];
//                int y = p[1] + d[1];
//                if (isValid(x, y) && grid[x][y] == 1 && !visited[x][y]) {
//                    stack.push(new int[]{x, y});
//                }
//            }
//        }
//    }
//
//    private void spread(List<int[]> affectedArea, List<int[]> adjacentCells) {
//        // spread to adjacent unaffected cells
//        for (int[] cell: adjacentCells) {
//            if (grid[cell[0]][cell[1]] == 0) {
//                // unaffected cell
//                grid[cell[0]][cell[1]] = 1;
//            }
//        }
//    }
//
//    private List<int[]> getAdjacentUnaffectedCells(List<int[]> area) {
//        // get unaffected cells adjacent to the area
//        boolean[][] visited = new boolean[m][n];
//        List<int[]> res = new ArrayList<>();
//        for (int[] cell: area) {
//            for (int[] d: directions) {
//                // add 4-directionally adjacent cells
//                int x = cell[0] + d[0];
//                int y = cell[1] + d[1];
//                if (isValid(x, y) && grid[x][y] == 0 && !visited[x][y]) {
//                    res.add(new int[]{x, y});
//                    visited[x][y] = true;
//                }
//            }
//        }
//        return res;
//    }
//
//    private boolean isValid(int x, int y) {
//        return x >= 0 && x < m && y >= 0 && y < n;
//    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(s.containVirus(new int[][]{
//                {0,1,0,0,0,0,0,1},
//                {0,1,0,0,0,0,0,1},
//                {0,0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,0,0}
//        })); // 10
//		System.out.println(s.containVirus(new int[][]{
//                {1,1,1},
//                {1,0,1},
//                {1,1,1}
//		})); // 4
//        System.out.println(s.containVirus(new int[][]{
//             {1,1,1,0,0,0,0,0,0},
//             {1,0,1,0,1,1,1,1,1},
//             {1,1,1,0,0,0,0,0,0}
//        })); // 13
//        System.out.println(s.containVirus(new int[][]{
//                {0,0,0,0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,0,0},
//                {1,0,0,0,0,0,0,0,0,0},
//                {0,0,1,0,0,0,1,0,0,0},
//                {0,0,0,0,0,0,1,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0,0,1,0},
//                {0,0,0,0,1,0,1,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0}
//        })); // 56
        System.out.println(s.containVirus(new int[][]{
                {0,1,0,1,1,1,1,1,1,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,1,1,1,0,0,0,1,0},
                {0,0,0,1,1,0,0,1,1,0},
                {0,1,0,0,1,0,1,1,0,1},
                {0,0,0,1,0,1,0,1,1,1},
                {0,1,0,0,1,0,0,1,1,0},
                {0,1,0,1,0,0,0,1,1,0},
                {0,1,1,0,0,1,1,0,0,1},
                {1,0,1,1,0,1,0,1,0,1}
        }));
     }
}