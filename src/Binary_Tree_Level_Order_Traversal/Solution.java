package Binary_Tree_Level_Order_Traversal;

import Others.Tree;
import Others.TreeNode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> nodes = new ArrayList<>();
        while (queue.size() > 0){
            while (!queue.isEmpty()) nodes.add(queue.poll());
            List<Integer> tmp = new ArrayList<>();
            for (TreeNode node : nodes) {
                tmp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(tmp);
            nodes.clear();
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> output1 = s.levelOrder(new Tree(new Object[]{3, 9, 20, null, null, 15, 7}).root);
        for (List<Integer> list: output1){
            for (int i: list) System.out.print(i + " ");
            System.out.println();
        }
	}
}