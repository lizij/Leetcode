package Sum_Root_to_Leaf_Numbers;

import Others.Tree;
import Others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * DFS solution
         * 3ms
         */
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums, "");
        int res = 0;
        for (Integer num: nums) {
            res += num;
        }
        return res;
    }

    private void dfs(TreeNode node, List<Integer> nums, String num) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            nums.add(Integer.valueOf(num + node.val));
            return;
        }
        dfs(node.left, nums, num + node.val);
        dfs(node.right, nums, num + node.val);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.sumNumbers(new Tree(new Object[]{1, 2, 3}).root));
	}
}