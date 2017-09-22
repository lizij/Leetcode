package Binary_Tree_Right_Side_View;

import Others.Tree;
import Others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int depth, List<Integer> res){
        if (node == null) return;
        if (res.size() == depth){
            res.add(node.val);
        }
        dfs(node.right, depth + 1, res);
        dfs(node.left, depth + 1, res);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}