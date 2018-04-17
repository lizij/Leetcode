package Find_Mode_in_Binary_Search_Tree;

import Others.Tree;
import Others.TreeNode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] findMode(TreeNode root) {
        /**
         * Depth First Search and count
         * 80ms
         */
        List<Integer> vals = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(root, vals);
        int maxfreq = 0;
        for (int i = 0; i < vals.size();) {
            int count = 1, val = vals.get(i);
            while (++i < vals.size() && vals.get(i) == val) count++;
            if (count >= maxfreq) {
                if (count > maxfreq) res.clear();
                res.add(val);
                maxfreq = count;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        dfs(node.left, vals);
        vals.add(node.val);
        dfs(node.right, vals);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		for (int i: s.findMode(new Tree(new Object[]{1, null, 2, null, null, 2}).root)) System.out.print(i + " ");
	}
}