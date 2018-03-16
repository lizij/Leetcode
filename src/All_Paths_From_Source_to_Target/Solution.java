package All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return null;
        }
        /**
         * DFS solution
         * 8ms
         */
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, res, path);
        return res;
    }
    
    private void dfs(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
        }

        for (int next: graph[node]) {
            path.add(next);
            dfs(graph, next, result, path);
            path.remove(path.size() - 1);
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.allPathsSourceTarget(new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        })); // [[0,1,3],[0,2,3]]
	}
}