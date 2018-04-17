package Two_Sum_IV_Input_is_a_BST;

import Others.Tree;
import Others.TreeNode;


public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return find(root, root, k);
    }

    private boolean binarySearch(TreeNode node, int value){
        if (node == null) return false;
        if (node.val == value) return true;
        return binarySearch(node.left, value) || binarySearch(node.right, value);
    }

    private boolean find(TreeNode root, TreeNode node, int target){
        if (node == null) return false;
        if (node.val != target - node.val && binarySearch(root, target - node.val)) return true;
        return find(root, node.left, target) || find(root, node.right, target);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findTarget(new Tree(new Object[]{5, 3, 6, 2, 4, null, 7}).root, 9));
        System.out.println(s.findTarget(new Tree(new Object[]{5, 3, 6, 2, 4, null, 7}).root, 28));
        System.out.println(s.findTarget(new Tree(new Object[]{1}).root, 2));
        System.out.println(s.findTarget(new Tree(new Object[]{2, 0, 3, -4, 1}).root, -1));
    }
}
