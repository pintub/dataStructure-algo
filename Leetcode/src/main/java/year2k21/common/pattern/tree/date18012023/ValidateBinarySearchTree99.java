package year2k21.common.pattern.tree.date18012023;

/**
 * Using InOrder traversal
 */
public class ValidateBinarySearchTree99 {

    private long previousElement = Long.MIN_VALUE;

    public boolean isValidBST_UsingInOrder(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean isLeftTreeBST = isValidBST_UsingInOrder(root.left);
        long temp = previousElement;
        previousElement = root.val;
        boolean isGreaterThanPrevElement = temp < root.val;
        boolean isRightTreeBST = isValidBST_UsingInOrder(root.right);

        return isLeftTreeBST && isGreaterThanPrevElement && isRightTreeBST;
    }

    public static void main(String[] args) {
        //TreeNode root = new TreeNode(13, new TreeNode(1), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
        TreeNode root = new TreeNode(1, new TreeNode(1), null);

        ValidateBinarySearchTree99 sol = new ValidateBinarySearchTree99();
        System.out.println(sol.isValidBST_UsingInOrder(root));
    }
}
