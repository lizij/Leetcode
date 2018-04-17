package Verify_Preorder_Serialization_of_a_Binary_Tree;

import java.util.Stack;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        /**
         * Graph solution
         * A tree is a fully-connected graph, with all nodes' in-degree sum equals to out-degree sum
         * A non-null node will provide 1 in-degree and 2 out-degree, except root node
         * A null node will provide 1 in-degree and 0 out-degree
         * During the traversal, if out-degree < in-degree, the serialization is invalid
         * 14ms
         */

        String[] nodes = preorder.split(",");
        int in = -1, out = 0;
        for (String n: nodes) {
            in++;
            if (out < in) {
                return false;
            }
            if (!n.equals("#")) {
                out += 2;
            }
        }
        return in == out;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")); // true
		System.out.println(s.isValidSerialization("1,#")); // false
		System.out.println(s.isValidSerialization("9,#,#,1")); // false
	}
}