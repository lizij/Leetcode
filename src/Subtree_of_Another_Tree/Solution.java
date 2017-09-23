package Subtree_of_Another_Tree;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        if (s.val == t.val){
            return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        else{
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2){
        return (node1 == null && node2 == null) || (node1 != null && node2 != null && node1.val == node2.val && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right));
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.isSubtree(new Tree(new Object[]{3, 4, 5, 1, 2}).root, new Tree(new Object[]{4, 1, 2}).root));
        StdOut.println(s.isSubtree(new Tree(new Object[]{3, 4, 5, 1, 2, null, null, null, null, 0}).root, new Tree(new Object[]{4, 1, 2}).root));
	}
}