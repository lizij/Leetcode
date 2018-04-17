package Most_Frequent_Subtree_Sum;

import Others.Tree;
import Others.TreeNode;


import java.util.*;

public class Solution {
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        dfs(root, frequencyMap);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
            if (entry.getValue() == max) list.add(entry.getKey());
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode node, HashMap<Integer, Integer> map){
        if (node == null) return 0;
        int sum = dfs(node.left, map) + dfs(node.right, map) + node.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        for (int i: s.findFrequentTreeSum(new Tree(new Object[]{5, 2, -3}).root)){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for (int i: s.findFrequentTreeSum(new Tree(new Object[]{5, 2, -5}).root)){
//            System.out.print(i + " ");
//        }
//        System.out.println();
        for (int i: s.findFrequentTreeSum(new Tree(new Object[]{0, -1}).root)){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
