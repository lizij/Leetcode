package Maximum_Depth_of_Binary_Tree;

import Others.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int d){
        if (node == null) return d;
        else{
            int left = dfs(node.left, d + 1);
            int right = dfs(node.right, d + 1);
            return Math.max(left, right);
        }
    }
}
