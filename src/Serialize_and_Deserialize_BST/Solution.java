package Serialize_and_Deserialize_BST;

import Others.Tree;
import Others.TreeNode;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    Codec codec;
    public Solution(){
        codec = new Codec();
    }

    public String testSerialize(TreeNode root){
        return codec.serialize(root);
    }

    public TreeNode testDeserialize(String data){
        return codec.deserialize(data);
    }

    public class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder builder = new StringBuilder();
            builder.append(root.val).append("#").append(serialize(root.left)).append(serialize(root.right));
            return builder.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] nodes = data.split("#");
            int[] input = new int[nodes.length];
            for (int i = 0; i < input.length; i++) input[i] = Integer.parseInt(nodes[i]);
            return generate(input, 0, input.length - 1);
        }

        private TreeNode generate(int[] input, int lo, int hi){
            if (lo > hi) return null;
            TreeNode node = new TreeNode(input[lo]);
            int sep;
            for (sep = lo + 1; sep <= hi && input[sep] < node.val; sep++);
            node.left = generate(input, lo + 1, sep - 1);
            node.right = generate(input, sep, hi);
            return node;
        }

        /**
         * generate any tree from in-order expression
         * memory limit exceeded
         */
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//            if (root == null) return "";
//            StringBuilder builder = new StringBuilder();
////            int depth = depth(root);
////            Object[] output = new Object[(int)Math.pow(2, depth) - 1];
////            generate(root, 0, output);
////            for (int i = 0; i < output.length; i++) {
////                if (output[i] == null) builder.append("N");
////                else builder.append(output[i]);
////                builder.append("#");
////            }
//            return builder.toString();
//        }
//
//        private int depth(TreeNode node){
//            if (node == null) return 0;
//            return Math.max(depth(node.left), depth(node.right)) + 1;
//        }
//
//        private void generate(TreeNode node, int pos, Object[] output){
//            if (node == null) return;
//            output[pos] = node.val;
//            generate(node.left, 2 * pos + 1, output);
//            generate(node.right, 2 * pos + 2, output);
//        }
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//            if (data == null || data.length() == 0) return null;
//            String[] nodes = data.split("#");
////            Object[] input = new Object[nodes.length];
////            for (int i = 0; i < nodes.length; i++) {
////                if (nodes[i].matches("\\d+")) input[i] = Integer.parseInt(nodes[i]);
////            }
////            return generate(input, 0);
//        }
//
//        private TreeNode generate(Object[] input, int pos){
//            if (pos >= input.length || input[pos] == null) return null;
//            TreeNode node = new TreeNode((int)input[pos]);
//            node.left = generate(input, 2 * pos + 1);
//            node.right = generate(input, 2 * pos + 2);
//            return node;
//        }

        // Your Codec object will be instantiated and called as such:
        // Codec codec = new Codec();
        // codec.deserialize(codec.serialize(root))

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String output = s.testSerialize(new Tree(new Object[]{4, 2, 6, 1, 3, 5, 7}).root);
        System.out.println(output);
        System.out.println(s.testDeserialize(output));
    }
}