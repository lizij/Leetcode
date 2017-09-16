package Convert_Sorted_Array_to_Binary_Search_Tree;

import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generate(nums, 0, nums.length - 1);
    }

    private TreeNode generate(int[] nums, int lo, int hi){
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = generate(nums, lo, mid - 1);
        node.right = generate(nums, mid + 1, hi);
        return node;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        StdOut.println(s.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7}));
	}
}