package Binary_Tree_Preorder_Traversal;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list){
        if (node == null) return;
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        for (int i: s.preorderTraversal(new Tree(new Object[]{4, 2, 6, 3, 1, 5}).root)){
            StdOut.print(i + " ");
        }
	}
}