package Maximum_Width_of_Binary_Tree;

import Others.Tree;
import Others.TreeNode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    private int dfs(TreeNode node, int level, int pos, List<Integer> start, List<Integer> end) {
        //null node
        if (node == null) return 0;

        //meet a new level, set left and right boundary as pos
        if (start.size() == level) {
            start.add(pos);
            end.add(pos);
        }
        else {
            //update old level's right boundary
            end.set(level, pos);
        }
        int left = dfs(node.left, level + 1, 2 * pos, start, end);
        int right = dfs(node.right, level + 1, 2 * pos + 1, start, end);
        //update all levels' boundaries below level
        int cur = end.get(level) - start.get(level) + 1;
        //return max of cur, left and right
        return Math.max(cur, Math.max(left, right));
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.widthOfBinaryTree(new Tree(new Object[]{1,3,2,5,3,null,9}).root));//4
        System.out.println(s.widthOfBinaryTree(new Tree(new Object[]{1,3,null,5,3}).root));//2
        System.out.println(s.widthOfBinaryTree(new Tree(new Object[]{1,3,2,5}).root));//2
        System.out.println(s.widthOfBinaryTree(new Tree(new Object[]{1,3,2,5,null,null,9,6,null,null,null,null,null,null,7}).root));//8
	}
}