package Maximum_Binary_Tree;

import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return generateTree(nums, 0, nums.length - 1);
    }

    private TreeNode generateTree(int[] a, int lo, int hi){
        if (hi < lo) return null;
        if (hi == lo) return new TreeNode(a[lo]);
        int maxpos = maxpos(a, lo, hi);
        TreeNode t = new TreeNode(a[maxpos]);
        t.left = generateTree(a, lo, maxpos - 1);
        t.right = generateTree(a, maxpos + 1, hi);
        return t;
    }

    private int maxpos(int[] a, int lo, int hi){
        int max = lo;
        for (int i = lo; i <= hi; i++) {
            if (a[i] > a[max]) max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 1, 6, 0, 5};
        Solution s = new Solution();
        TreeNode root = s.constructMaximumBinaryTree(input);
    }
}
