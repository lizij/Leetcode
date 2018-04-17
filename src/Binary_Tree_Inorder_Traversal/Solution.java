package Binary_Tree_Inorder_Traversal;

import Others.Tree;
import Others.TreeNode;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode node, List<Integer> list){
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		for (int i: s.inorderTraversal(new Tree(new Object[]{4, 2, 6, 3, 1, 5}).root)){
            System.out.print(i + " ");
        }
	}
}