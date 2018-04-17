package Binary_Search_Tree_Iterator;

import Others.Tree;
import Others.TreeNode;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class Solution{
    BSTIterator bstIterator;
    Solution(TreeNode root){
        bstIterator = new BSTIterator(root);
    }
    public class BSTIterator {
        Queue<Integer> queue;

        public BSTIterator(TreeNode root) {
            queue = new LinkedList<>();
            dfs(root);
        }

        private void dfs(TreeNode node){
            if (node == null) return;
            dfs(node.left);
            queue.offer(node.val);
            dfs(node.right);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return queue.size() > 0;
        }

        /** @return the next smallest number */
        public int next() {
            return hasNext() ? queue.poll() : -1;
        }
    }

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
	public static void main(String[] args) {
		Solution s = new Solution(new Tree(new Object[]{4, 2, 6, 1, 3, 5, 7}).root);
        while (s.bstIterator.hasNext()) System.out.print(s.bstIterator.next() + " ");
	}
}