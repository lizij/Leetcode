package House_Robber_III;

import Others.Tree;
import Others.TreeNode;


import java.util.HashMap;

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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        HashMap<TreeNode, int[]> map = new HashMap<>();
        int[] res = rub(root, map);
        return Math.max(res[0], res[1]);
    }

    private int[] rub(TreeNode node, HashMap<TreeNode, int[]> map){
        int[] val = new int[2];
        if (node == null) return val;
        if (map.containsKey(node)) return map.get(node);
        int[] left = rub(node.left, map);
        int[] right = rub(node.right, map);

        val[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        val[1] = node.val + left[0] + right[0];
        map.put(node, val);
        return val;
    }

//    private int dfs(TreeNode node, boolean parentIsRubed){
//        if (node == null) return 0;
//        if (parentIsRubed){
//            return dfs(node.left, false) + dfs(node.right, false);
//        }
//        else{
//            int leftrub = 0, rightrub = 0, leftnorub = 0, rightnorub = 0;
//            if (node.left != null){
//                leftrub = node.left.val + dfs(node.left, true);
//                leftnorub = dfs(node.left, false);
//            }
//            if (node.right != null){
//                rightrub = node.right.val + dfs(node.right, true);
//                rightnorub = dfs(node.right, false);
//            }
//            return Math.max(leftnorub + rightnorub, Math.max(leftrub + rightnorub, Math.max(leftnorub + rightrub, leftrub + rightrub)));
//        }
//    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.rob(new Tree(new Object[]{3, 2, 3, null,3, null, 1}).root));
        System.out.println(s.rob(new Tree(new Object[]{3, 4, 5, 1, 3, null, 1}).root));
	}
}