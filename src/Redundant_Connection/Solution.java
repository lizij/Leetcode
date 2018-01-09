package Redundant_Connection;

import java.util.*;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return null;
        }
        /**
         * Use union-find to detect circles
         * 23ms
         */
//        UnionFind uf = new UnionFind();
//        Map<Integer, Node> nodeMap = new HashMap<>();
//        // init nodes
//        for (int[] edge: edges) {
//            for (int v: edge) {
//                if (!nodeMap.containsKey(v)) {
//                    nodeMap.put(v, new Node(v));
//                }
//            }
//        }
//
//        // add nodes to union-isSameParent
//        uf.insert(nodeMap.values());
//
//        for (int[] edge: edges) {
//            Node a = nodeMap.get(edge[0]);
//            Node b = nodeMap.get(edge[1]);
//
//            if (uf.isSameRoot(a, b)) {
//                // there is path from a to b. Adding [a, b] will generate a circle
//                return edge;
//            }
//            uf.union(a, b);
//        }
//        return new int[]{};

        /**
         * Use simple union find instead
         * 9ms
         */
        SimpleUnionFind suf = new SimpleUnionFind();
        for (int[] edge: edges) {
            if (suf.isSameParent(edge[0], edge[1])) {
                return edge;
            }
            suf.union(edge[0], edge[1]);
        }
        return new int[2];
    }

    class SimpleUnionFind {
        // simple specific union-find for this problem, faster
        private final static int MAX_SIZE = 1001;
        int[] parent;
        int[] rank;

        public SimpleUnionFind() {
            parent = new int[MAX_SIZE];
            rank = new int[MAX_SIZE];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        public boolean isSameParent(int a, int b) {
            return find(a) == find(b);
        }

        public void union(int a, int b) {
            int ap = find(a);
            int bp = find(b);
            if (ap == bp) {
                return;
            }

            if (rank[ap] < rank[bp]) {
                parent[ap] = bp;
                rank[bp] += rank[ap];
            } else {
                parent[bp] = ap;
                rank[ap] += rank[bp];
            }
        }
    }

    class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + value + ")";
        }
    }

    private class UnionFind {
        HashMap<Node, Node> rootMap;
        HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            rootMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void insert(Collection<Node> nodes) {
            for (Node node: nodes) {
                rootMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public boolean isSameRoot(Node a, Node b) {
            if (a == null || b == null || !rootMap.containsKey(a) || !rootMap.containsKey(b)) {
                throw new IllegalArgumentException("Invalid Node a or b");
            }
            return find(a) == find(b);
        }

        private Node find(Node node) {
            if (node == null) {
                return null;
            }

            Node root = rootMap.get(node);
            if (root != node) {
                root = find(root);
            }
            rootMap.put(node, root);
            return root;
        }

        public void union(Node a, Node b) {
            if (a == null || b == null || !rootMap.containsKey(a) || !rootMap.containsKey(b)) {
                throw new IllegalArgumentException("Invalid Node a or b");
            }

            Node aRoot = rootMap.get(a);
            Node bRoot = rootMap.get(b);
            if (aRoot != bRoot) {
                return;
            }

            int aSize = sizeMap.get(aRoot);
            int bSize = sizeMap.get(bRoot);

            if (aSize > bSize) {
                rootMap.put(bRoot, aRoot);
                sizeMap.put(aRoot, aSize + bSize);
            } else {
                rootMap.put(aRoot, bRoot);
                sizeMap.put(bRoot, aSize + bSize);
            }
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}))); // 2,3
		System.out.println(Arrays.toString(s.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}))); // 2,3
	}
}