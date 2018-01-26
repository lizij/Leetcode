package Count_Complete_Tree_Nodes;

import Others.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        /**
         * Two key points:
         * 1. Full binary tree: This means the leftmost node is possibly further than the rightmost node
         *                      we need to find which sub tree is unbalanced
         * 2. Shift bit instead of Math.pow()...
         * 107ms
         */

        int left = 0, right = 0;
        TreeNode leftmost = root, rightmost = root;
        while (leftmost != null) {
            left++;
            leftmost = leftmost.left;
        }

        while (rightmost != null) {
            right++;
            rightmost = rightmost.right;
        }

        if (left == right) return (1 << left) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}