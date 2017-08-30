package Others;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Tree {
    public TreeNode root;
    private int N;

    public Tree(TreeNode root){this.root = root;}
    public Tree(Object[] a){
        root = generateTreeFromArray(a, 0);
    }

    public int size(){return N;}

    private TreeNode generateTreeFromArray(Object[] a, int i){
        TreeNode node;
        if (i >= a.length || a[i] == null) return null;
        node = new TreeNode((int)a[i]);
        node.left = generateTreeFromArray(a, 2 * i + 1);
        node.right = generateTreeFromArray(a, 2 * i + 2);
        N++;
        return node;
    }

    public static void main(String[] args) {
        Object[] a = {1, 3, 2, 5};
        Object[] b = {2, 1, 3, null, 4, null, 7};
        Tree at = new Tree(a);
        Tree bt = new Tree(b);

        StdOut.println(at.root);
        StdOut.println(bt.root);
    }

    @Override
    public String toString() {
        return "Tree{" + root.toString() + "}";
    }
}
