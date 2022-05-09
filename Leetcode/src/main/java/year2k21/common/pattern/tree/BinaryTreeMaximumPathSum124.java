package year2k21.common.pattern.tree;

/**
 * Think similar to diameter of tree
 */
public class BinaryTreeMaximumPathSum124 {

    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxPathDownOneSideBranch(root);

        return maxPathSum;
    }

    private int maxPathDownOneSideBranch(TreeNode root) {
        if (root == null)
            return 0;

        int maxPathSumAtRoot = root.val;
        int maxPathDownLeftBranch = maxPathDownOneSideBranch(root.left);
        int maxPathDownRightBranch = maxPathDownOneSideBranch(root.right);

        if(maxPathDownLeftBranch >= 0) {
            maxPathSumAtRoot += maxPathDownLeftBranch;
        }

        if(maxPathDownRightBranch >= 0) {
            maxPathSumAtRoot += maxPathDownRightBranch;
        }

        maxPathSum = Math.max(maxPathSum, maxPathSumAtRoot);

        return Math.max(root.val, Math.max(root.val + maxPathDownLeftBranch, root.val + maxPathDownRightBranch));
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, null, null);
        //TreeNode right = new TreeNode(3, null, null);
        //TreeNode node = new TreeNode(1, left, right);

        System.out.println(new BinaryTreeMaximumPathSum124().maxPathSum(left));
    }
}
