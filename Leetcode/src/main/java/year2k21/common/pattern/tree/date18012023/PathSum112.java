package year2k21.common.pattern.tree.date18012023;

public class PathSum112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        boolean isLeaf = isLeaf(root);

        if(isLeaf && targetSum == root.val) {
            return true;
        }

        if(isLeaf) {
            return false;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2, null, new TreeNode(-3));
        System.out.println(new PathSum112().hasPathSum(root, -5));
    }
}
