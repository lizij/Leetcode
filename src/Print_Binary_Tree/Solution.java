package Print_Binary_Tree;

import Others.Tree;
import Others.TreeNode;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int depth = depth(root);
        int length = (1 << depth) - 1;
        List<List<String>> tree = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < length; j++) list.add("");
            tree.add(list);
        }
        setTree(root, tree, 0, length - 1, 0);
        return tree;
    }

    private int depth(TreeNode node){
        if (node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    private void setTree(TreeNode node, List<List<String>> tree, int lo, int hi, int depth){
        if (node == null) return;
        int mid = (lo + hi) / 2;
        tree.get(depth).set(mid, String.valueOf(node.val));
        setTree(node.left, tree, lo, mid - 1, depth + 1);
        setTree(node.right, tree, mid + 1, hi, depth + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (List<String> stringList: s.printTree(new Tree(new Object[]{1, 2}).root)){
            for (String string: stringList) StdOut.print(string + " ");
            StdOut.println();
        }

        for (List<String> stringList: s.printTree(new Tree(new Object[]{1, 2, 3, null, 4}).root)){
            for (String string: stringList) StdOut.print(string + " ");
            StdOut.println();
        }
    }
}
