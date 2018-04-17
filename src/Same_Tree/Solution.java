package Same_Tree;

import Others.Tree;
import Others.TreeNode;


public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return p == null && q == null || p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.isSameTree(new Tree(new Object[]{1, 2, 3, null, 4}).root, new Tree(new Object[]{1, 2, 3, null, 4}).root));
        System.out.println(s.isSameTree(new Tree(new Object[]{1, 2, 3, null, 4}).root, new Tree(new Object[]{1, 2, 3, null, 4, 5}).root));
        System.out.println(s.isSameTree(new Tree(new Object[]{1, 2, 3, null, 4}).root, new Tree(new Object[]{1, 2, 3, null, 6, 5}).root));
        System.out.println(s.isSameTree(new Tree(new Object[]{1, 2, 3, null, 4}).root, new Tree(new Object[]{1, 2, null, null, 6}).root));
	}
}