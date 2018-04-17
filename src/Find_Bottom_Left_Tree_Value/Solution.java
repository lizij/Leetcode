package Find_Bottom_Left_Tree_Value;

import Others.Tree;
import Others.TreeNode;


import java.util.HashMap;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, 0, map);
        int depth = 0;
        for (int i: map.keySet()) depth = depth >= i?depth:i;
        return map.get(depth);
    }

    private void dfs(TreeNode node, int d, HashMap<Integer, Integer> map){
        if (node == null) return;
        if (!map.containsKey(d)) map.put(d, node.val);
        dfs(node.left, d + 1, map);
        dfs(node.right, d + 1, map);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Object[] input = {1, 2, 3, 4, null, 5, 6, null, null, null, null, 7};
        Tree tree = new Tree(input);
        System.out.println(s.findBottomLeftValue(tree.root));
    }
}
