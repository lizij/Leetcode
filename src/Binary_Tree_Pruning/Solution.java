package Binary_Tree_Pruning;

import Others.Tree;
import Others.TreeNode;

public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        /**
         * Recursion solution
         * 2ms
         */
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        return root.val == 0 && root.left == null && root.right == null ? null : root;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.pruneTree(new Tree(new Object[]{1,null,0,0,1}).root)); // [1,null,0,null,1]
		System.out.println(s.pruneTree(new Tree(new Object[]{1,0,1,0,0,0,1}).root)); // [1,null,1,null,1]
		System.out.println(s.pruneTree(new Tree(new Object[]{1,1,0,1,1,0,1,0}).root)); // [1,1,0,1,1,null,1]
	}
}