package Others;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val + "(");
        if (left != null) builder.append(left.toString());
        else builder.append("N");
        builder.append("|");
        if (right != null) builder.append(right.toString());
        else builder.append("N");
        builder.append(")");
        return builder.toString();
    }
}
