package Trim_a_Binary_Search_Tree;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        int value = root.val;
        if (R < value) return trimBST(root.left, L, R);
        if (L > value) return trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, value);
        root.right = trimBST(root.right, value, R);
        return root;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.trimBST(new Tree(new Object[]{1, 2, 2}).root, 1, 2));
        StdOut.println(s.trimBST(new Tree(new Object[]{3, 0, 4, null, 2, null, null, null, null, 1}).root, 1, 3));
	}
}