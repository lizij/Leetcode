package Average_of_Levels_in_Binary_Tree;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        HashMap<Integer, Long[]> map = new HashMap<>();
        dfs(map, root, 0);
        List<Double> list = new ArrayList<>();
        for (int i = 0; map.get(i) != null ; i++) {
            Long[] value = map.get(i);
            list.add((double) value[0] / value[1]);
        }
        return list;
    }

    private void dfs(HashMap<Integer, Long[]> map, TreeNode node, int d){
        if (node == null) return;
        Long[] value = new Long[2];
        if (!map.containsKey(d)){
            value[0] = new Long(node.val);
            value[1] = new Long(1);
        }
        else{
            value = map.get(d);
            value[0] += node.val;
            value[1]++;
        }
        map.put(d, value);
        dfs(map, node.left, d + 1);
        dfs(map, node.right, d + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Object[] input = {2147483647,2147483647,2147483647};
//        Object[] input = {3, 9, 20, 15, 7};
//        Object[] input = {3, 9, 20, null, null, 15, 7};
        Tree t = new Tree(input);
        List<Double> list = s.averageOfLevels(t.root);
        for (double d: list){
            StdOut.print(d + " ");
        }
    }
}
