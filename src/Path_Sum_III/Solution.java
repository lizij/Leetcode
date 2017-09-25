package Path_Sum_III;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, map, sum, 0);
    }

    private int dfs(TreeNode node, Map<Integer, Integer> map, int k, int sum){
        if (node == null) return 0;
        sum = node.val + sum;
        int res = map.getOrDefault(sum - k, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        res += dfs(node.left, map, k, sum) + dfs(node.right, map, k, sum);
        map.put(sum, map.get(sum) - 1);
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        StdOut.println(s.pathSum(new Tree(new Object[]{10,5,-3,3,2,null,11,3,-2,null,1}).root, 8));//3
        StdOut.println(s.pathSum(new Tree(new Object[]{5,4,8,11,null,13,4,7,2,null,null,5,1}).root, 22));//3
	}
}