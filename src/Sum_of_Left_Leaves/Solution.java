package Sum_of_Left_Leaves;

import Others.Tree;
import Others.TreeNode;


public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
//        return sumOfLeftLeaves(root, false);
        if (root.left != null && root.left.left == null && root.left.right == null) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean isLeft){
        if (node == null) return 0;
        if (isLeft && node.left == null) return node.val + sumOfLeftLeaves(node.right, false);
        else return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.sumOfLeftLeaves(new Tree(new Object[]{3, 9, 20, null, null, 15, 7}).root));
        System.out.println(s.sumOfLeftLeaves(new Tree(new Object[]{1, 2, 3, 4, 5}).root));
	}
}