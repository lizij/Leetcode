package Binary_Tree_Paths;

import Others.Tree;
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> path, List<String> res){
        if (node == null) return;
        if (node.left == null && node.right == null){
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                builder.append(path.get(i)).append("->");
            }
            builder.append(node.val);
            res.add(builder.toString());
        }
        path.add(node.val);
        dfs(node.left, path, res);
        dfs(node.right, path, res);
        path.remove(path.size() - 1);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.binaryTreePaths(new Tree(new Object[]{1,2,3,null,5}).root));
	}
}