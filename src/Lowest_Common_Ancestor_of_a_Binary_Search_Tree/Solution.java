package Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (p.val > q.val){TreeNode t = p;p = q;q = t;}
        if (root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }

    private boolean isDescendant(TreeNode anc, TreeNode des){
        if (anc == null || des == null) return false;
        return anc.equals(des) || isDescendant(anc.left, des) || isDescendant(anc.right, des);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		Tree input1 = new Tree(new Object[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
//        StdOut.println(s.lowestCommonAncestor(input1.root, input1.root.left.left, input1.root.left.right.right));
        StdOut.println(s.lowestCommonAncestor(input1.root, input1.root, input1.root.left));
	}
}