package Binary_Tree_Postorder_Traversal;

import Others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list){
        if (node == null) return;
        dfs(node.left, list);
        dfs(node.right, list);
        list.add(node.val);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}