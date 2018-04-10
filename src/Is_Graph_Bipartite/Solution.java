package Is_Graph_Bipartite;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }

        /**
         * DFS solution: Mark every node with 0 or 1
         * If visited[from] == mark, visited[to] should be marked with 1-mark.
         * If visited[from] == visited[to], the grash is not bipartite
         * 11ms
         */

        int[] visited = new int[graph.length]; // mark 0 or 1
        Arrays.fill(visited, -1); // -1 for unvisited
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1 && !dfs(graph, i, visited, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int from, int[] visited, int mark) {
        if (visited[from] != -1) {
            return visited[from] == mark;
        }

        visited[from] = mark;
        for (int to: graph[from]) {
            if (!dfs(graph, to, visited, 1 - mark)) {
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isBipartite(new int[][]{{1,3}, {0,2}, {1,3}, {0,2}})); // true
		System.out.println(s.isBipartite(new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}})); // true
	}
}