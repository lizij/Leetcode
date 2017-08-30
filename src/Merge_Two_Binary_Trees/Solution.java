package Merge_Two_Binary_Trees;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root;
        if (t1 == null && t2 == null) return null;
        if (t1 == null && t2 != null) root = t2;
        else if (t1 != null && t2 == null) root = t1;
        else {
            root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        return root;
    }

    public static void main(String[] args) {
        Object[] a = {1, 3, 2, 5};
        Object[] b = {2, 1, 3, null, 4, null, 7};
        Tree at = new Tree(a);
        Tree bt = new Tree(b);

        Solution s = new Solution();
        StdOut.println(s.mergeTrees(at.root, bt.root));
    }
}
