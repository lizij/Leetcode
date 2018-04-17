package Diameter_of_Binary_Tree;

import Others.Tree;
import Others.TreeNode;


public class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node){
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        System.out.println(s.diameterOfBinaryTree(new Tree(new Object[]{1, 2, 3, 4, 5}).root));
//        System.out.println(s.diameterOfBinaryTree(new Tree(new Object[]{}).root));
//        System.out.println(s.diameterOfBinaryTree(new Tree(new Object[]{1}).root));
        System.out.println(s.diameterOfBinaryTree(new Tree(new Object[]{1,null,-9,null,8,4,-3,null,null,-3,null,-6,null,null,-6,-4,-9,null,null,6}).root));
	}
}