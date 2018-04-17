package Add_One_Row_to_Tree;

import Others.Tree;
import Others.TreeNode;


public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return null;
        if (d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        root = addOneRow(root, v, d, 1);
        return root;
    }

    private TreeNode addOneRow(TreeNode node, int value, int depth, int curDepth){
        if (node == null) return null;
        if (curDepth == depth - 1){
            TreeNode left = new TreeNode(value);
            TreeNode right = new TreeNode(value);
            left.left = node.left;
            right.right = node.right;
            node.left = left;
            node.right = right;
        }
        else{
            node.left = addOneRow(node.left, value, depth, curDepth + 1);
            node.right = addOneRow(node.right, value, depth, curDepth + 1);
        }
        return node;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.addOneRow(new Tree(new Object[]{4, 2, 6, 3, 1, 5}).root, 1, 2));
        System.out.println(s.addOneRow(new Tree(new Object[]{4, 2, null, 3, 1}).root, 1, 3));
	}
}