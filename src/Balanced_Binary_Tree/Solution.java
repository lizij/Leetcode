package Balanced_Binary_Tree;

import Others.Tree;
import Others.TreeNode;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        /**
         * Without any cache
         * 2ms
         */
        return root == null || Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        /**
         * Add Map as cache
         * 9ms
         */
//        Map<TreeNode, Integer> map = new HashMap<>();
//        return isBalanced(root, map);
    }

    private boolean isBalanced(TreeNode node, Map<TreeNode, Integer> map) {
        return node == null || Math.abs(depth(node.left, map) - depth(node.right, map)) <= 1 && isBalanced(node.left, map) && isBalanced(node.right, map);
    }

    private int depth(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return 0;
        if (map.containsKey(node)) return map.get(node);
        int depth = Math.max(depth(node.left, map), depth(node.right, map)) + 1;
        map.put(node, depth);
        return depth;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.isBalanced(new Tree(new Object[]{1,2}).root));
        System.out.println(s.isBalanced(new Tree(new Object[]{1,2,2,3,null,null,3,4,null,null,4}).root));
	}
}