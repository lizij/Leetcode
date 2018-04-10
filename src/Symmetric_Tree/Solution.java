package Symmetric_Tree;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        /**
         * non-recursive solution
         * 4ms
         */
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (queue.size() > 0) {
//            List<TreeNode> line = new ArrayList<>();
//            while (queue.size() > 0){ line.add(queue.poll()); }
//            for (TreeNode aLine : line) {
//                if (aLine == null) continue;
//                queue.add(aLine.left);
//                queue.add(aLine.right);
//            }
//            for (int i = 0, j = line.size() - 1; i < j; i++,j--) {
//                if (!(line.get(i) == null && line.get(j) == null) && !(line.get(i) != null && line.get(j) != null && line.get(i).val == line.get(j).val)) return false;
//            }
//            line.clear();
//        }
//        return true;
        /**
         * recursive solution
         * 2ms
         */
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        return left == null && right == null
                || left != null && right != null && left.val == right.val
                && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.isSymmetric(new Tree(new Object[]{1,2,2,3,4,4,3}).root));
        StdOut.println(s.isSymmetric(new Tree(new Object[]{1,2,2,null,3,null,3}).root));
	}
}