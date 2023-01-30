package year2k21.common.pattern.tree.date18012023;

//POST-Order
public class MaximumDepthOfBinaryTree104 {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
