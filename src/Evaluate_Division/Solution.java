package Evaluate_Division;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<Edge>> graph = addEdges(equations, values);
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            double val = dfs(queries[i][0], queries[i][1], graph, null);
            res[i] = val != 0.0 ? val : -1.0;
        }
        return res;
    }

    private double dfs(String from, String to, HashMap<String, List<Edge>> graph, HashSet<String> set){
        if (!graph.containsKey(from) || !graph.containsKey(to)) return 0.0;
        if (from.equals(to)) return 1.0;
        if (set == null) set = new HashSet<>();
        set.add(from);
        List<Edge> edges = graph.get(from);
        double res = 0.0;
        for (Edge e: edges){
            if (set.contains(e.to)) continue;
            if (e.to.equals(to)){
                res = e.val;
                break;
            }
            else{
                double tmp = e.val * dfs(e.to, to, graph, set);
                if (tmp != 0.0){
                    res = tmp;
                    break;
                }
            }
        }
        set.remove(from);
        return res;
    }

    private HashMap<String, List<Edge>> addEdges(String[][] equations, double[] values){
        HashMap<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            List<Edge> edgeOfFrom = graph.getOrDefault(equations[i][0], new ArrayList<>());
            List<Edge> edgeOfTo = graph.getOrDefault(equations[i][1], new ArrayList<>());
            edgeOfFrom.add(new Edge(equations[i][0], equations[i][1], values[i]));
            edgeOfTo.add(new Edge(equations[i][1], equations[i][0], 1.0 / values[i]));
            graph.put(equations[i][0], edgeOfFrom);
            graph.put(equations[i][1], edgeOfTo);
        }
        return graph;
    }

    private class Edge{
        String from;
        String to;
        double val;

        public Edge(String name, String adj, double val) {
            this.from = name;
            this.to = adj;
            this.val = val;
        }

        @Override
        public String toString() {
            return "{" + from + "/"  + to + "=" + val + "}";
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		double[] output1 = s.calcEquation(new String[][]{{"a","b"},{"b","c"}}, new double[]{2.0, 3.0}, new String[][]{ {"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}});
//		for (double d: output1) System.out.print(d + " ");
		double[] output2 = s.calcEquation(new String[][]{{"a","b"},{"e","f"},{"b","e"}}, new double[]{3.4,1.4,2.3}, new String[][]{{"b","a"},{"a","f"},{"f","f"},{"e","e"},{"c","c"},{"a","c"},{"f","e"}});
		for (double d: output2) System.out.print(d + " ");
	}
}