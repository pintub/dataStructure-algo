package year2k21.common.pattern.tree.date18012023;

public class InvertBinaryTree226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }
}
