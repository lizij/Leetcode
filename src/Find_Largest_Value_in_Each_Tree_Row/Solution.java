package Find_Largest_Value_in_Each_Tree_Row;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findLargestValues(list, root, 0);
        return list;
    }

    private void findLargestValues(List<Integer> list, TreeNode node, int depth){
        if (node == null) return;
        if (depth == list.size()) list.add(depth, node.val);
        else list.set(depth, Math.max(node.val, list.get(depth)));
        findLargestValues(list, node.left, depth + 1);
        findLargestValues(list, node.right, depth + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Tree tree = new Tree(new Object[]{1, 3, 2, 5, 3, null, 9});
        for (Integer i: s.largestValues(tree.root)){
            StdOut.print(i + " ");
        }
    }
}
