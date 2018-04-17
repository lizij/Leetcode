package Binary_Tree_Tilt;

import Others.Tree;
import Others.TreeNode;


import java.util.HashMap;

public class Solution {
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        HashMap<TreeNode, Integer> map = new HashMap<>();
        sum(root, map);
        return findTilt(root, map);
    }

    private int findTilt(TreeNode node, HashMap<TreeNode, Integer> map){
        if (node == null) return 0;
        int tilt = Math.abs(map.getOrDefault(node.left, 0) - map.getOrDefault(node.right, 0));
        return tilt + findTilt(node.left, map) + findTilt(node.right, map);
    }

    private int sum(TreeNode node, HashMap<TreeNode, Integer> map){
        if (node == null) return 0;
        int sum = node.val + sum(node.left, map) + sum(node.right, map);
        map.put(node, sum);
        return sum;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.findTilt(new Tree(new Object[]{1, 2, 3}).root));
        System.out.println(s.findTilt(new Tree(new Object[]{4, 2, 6, 3, 1, null, 5}).root));
	}
}