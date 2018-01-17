package Delete_Node_in_a_BST;

import Others.Tree;
import Others.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        /**
         * Straight forward solution
         * Use 2 pointers, cur and parent (parent of cur), to find the node in the BST. If not found, return newRoot (default as root)
         * Then reset parent.left or parent.right:
         * 1. If cur is a leave node, return null
         * 2. If cur only have one child, return that child
         * 3. If cur have 2 children, find the most right node in the cur.left subtree (its right must be null), then set its right as cur.left
         * Finally return the newRoot
         * 7ms
         */

        TreeNode parent = null, cur = root, newRoot = root;
        while (cur != null) {
            if (key < cur.val) {
                // move to  left
                parent = cur;
                cur = cur.left;
            } else if (key > cur.val) {
                // move to right
                parent = cur;
                cur = cur.right;
            } else {
                // cur.val == key, delete node cur
                if (parent == null) {
                    // root.val == key
                    newRoot = deleteNode(cur);
                } else {
                    if (parent.left == cur) {
                        // parent.left == cur, reset parent.left
                        parent.left = deleteNode(cur);
                    } else {
                        // parent.right == cur, reset parent.right
                        parent.right = deleteNode(cur);
                    }
                }
                break;
            }
        }
        return newRoot;
    }

    private TreeNode deleteNode(TreeNode node) {
        if (node == null) {
            // error check
            return null;
        }

        if (node.left == null && node.right == null) {
            // leave node
            return null;
        }

        // node.left or node.right is null
        if (node.left != null && node.right == null) {
            return node.left;
        }

        if (node.left == null && node.right != null) {
            return node.right;
        }

        // both node.left and node.right not null
        // find the most right node in node.left, then set its right as node.right
        TreeNode mostright = node.left;
        while (mostright.right != null) {
            mostright = mostright.right;
        }
        mostright.right = node.right;
        return node.left;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.deleteNode(new Tree(new Object[]{5,3,6,2,4,null,7}).root, 3)); // [5,4,6,2,null,null,7] or [5,2,6,null,4,null,7]
	}
}