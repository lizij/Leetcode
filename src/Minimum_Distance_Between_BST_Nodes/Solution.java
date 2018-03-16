package Minimum_Distance_Between_BST_Nodes;

import Others.Tree;
import Others.TreeNode;

import java.util.Stack;

public class Solution {
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }

        /**
         * In-order traversal
         * Remember the last visited node and compare it with the current node
         * 5ms
         */

        TreeNode cur = root;
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<>();
        int res = Integer.MAX_VALUE;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (last != null) {
                    res = Math.min(res, cur.val - last.val);
                }
                last = cur;
                cur = cur.right;
            }
        }

        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.minDiffInBST(new Tree(new Object[]{4, 2, 6, 1, 3 ,null, null}).root)); // 1
	}
}