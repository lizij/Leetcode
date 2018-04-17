package Convert_BST_to_Greater_Tree;

import Others.Tree;
import Others.TreeNode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        treeToList(root, nodeList);
        for (int i = nodeList.size() - 2; i >= 0; i--) nodeList.get(i).val += nodeList.get(i + 1).val;
        return root;
    }

    private void treeToList(TreeNode node, List<TreeNode> list){
        if (node == null) return;
        treeToList(node.left, list);
        list.add(node);
        treeToList(node.right, list);
    }
    
	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.convertBST(new Tree(new Object[]{4, 2, 6, 1, 3, 5, 7}).root));
	}
}