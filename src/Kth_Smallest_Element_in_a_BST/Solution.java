package Kth_Smallest_Element_in_a_BST;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k - 1);
    }

    private void dfs(TreeNode node, List<Integer> list){
        if (node == null) return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.kthSmallest(new Tree(new Object[]{4, 2, 6, 1, 3, 5, 7}).root, 5));
	}
}