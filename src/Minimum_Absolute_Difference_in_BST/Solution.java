package Minimum_Absolute_Difference_in_BST;

import Others.Tree;
import Others.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        list.sort(Comparator.comparingInt(a -> a));
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }

    private void dfs(TreeNode node, List<Integer> list){
        if (node == null) return;
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}