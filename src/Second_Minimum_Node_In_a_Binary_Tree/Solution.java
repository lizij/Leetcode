package Second_Minimum_Node_In_a_Binary_Tree;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

import java.util.PriorityQueue;

public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        dfs(root, queue);
        int min = queue.poll();
        while (queue.size() > 0 && queue.peek() == min) queue.poll();
        return queue.size() != 0 ? queue.poll() : -1;
    }

    private void dfs(TreeNode node, PriorityQueue<Integer> queue){
        if (node == null) return;
        dfs(node.left, queue);
        queue.offer(node.val);
        dfs(node.right, queue);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.findSecondMinimumValue(new Tree(new Object[]{2, 2, 5, null, null, 5, 7}).root));
        StdOut.println(s.findSecondMinimumValue(new Tree(new Object[]{2, 2, 2}).root));
	}
}