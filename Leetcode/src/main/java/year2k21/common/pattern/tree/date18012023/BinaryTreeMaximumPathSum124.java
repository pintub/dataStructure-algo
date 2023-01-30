package year2k21.common.pattern.tree.date18012023;

public class BinaryTreeMaximumPathSum124 {

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        oneDirectionalMaxPath(root);

        return result;
    }

    private int oneDirectionalMaxPath(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftTreeResult = oneDirectionalMaxPath(root.left);
        int rightTreeResult = oneDirectionalMaxPath(root.right);

        int oneDirectionalBranchMaxPath = root.val;
        oneDirectionalBranchMaxPath = Math.max(oneDirectionalBranchMaxPath, root.val + leftTreeResult);
        oneDirectionalBranchMaxPath = Math.max(oneDirectionalBranchMaxPath, root.val + rightTreeResult);

        result = Math.max(result, Math.max(oneDirectionalBranchMaxPath,  root.val + leftTreeResult + rightTreeResult));

        return oneDirectionalBranchMaxPath;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum124 sol = new BinaryTreeMaximumPathSum124();
        TreeNode treeNode = new TreeNode(0);
        System.out.println(sol.maxPathSum(treeNode));
    }
}
