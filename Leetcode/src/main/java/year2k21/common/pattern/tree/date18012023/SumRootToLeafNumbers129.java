package year2k21.common.pattern.tree.date18012023;

/**
 * Type2 Recursion Top-Down
 */
public class SumRootToLeafNumbers129 {

    private int rootToLeafNumbersSum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);

        return rootToLeafNumbersSum;
    }

    private void sumNumbers(TreeNode root, int prefix) {
        if(root == null) {
            return;
        }

        int newPrefix = prefix * 10 + root.val;

        if(root.left == null && root.right == null){
            rootToLeafNumbersSum += newPrefix;
            return;
        }


        sumNumbers(root.left, newPrefix);
        sumNumbers(root.right, newPrefix);
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers129 sol = new SumRootToLeafNumbers129();
        TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0, null, new TreeNode(1)));
        System.out.println(sol.sumNumbers(root));
    }
}
