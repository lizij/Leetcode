package Invert_Binary_Tree;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Tree tree = new Tree(new Object[]{4, 2, 7, 1, 3, 6, 9});
        StdOut.println(tree.root);
        StdOut.println(s.invertTree(tree.root));
    }
}
