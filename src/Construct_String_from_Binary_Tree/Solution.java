package Construct_String_from_Binary_Tree;

import Others.Tree;
import Others.TreeNode;


public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String left = "(" + tree2str(t.left) + ")";
        String right = "(" + tree2str(t.right) + ")";
        if (right.equals("()")){
            if (left.equals("()")) return t.val + "";
            else return t.val + left;
        }
        return t.val + left + right ;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.tree2str(new Tree(new Object[]{1, 2, 3, 4}).root));
        System.out.println(s.tree2str(new Tree(new Object[]{1, 2, 3, null, 4}).root));
	}
}