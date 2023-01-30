package year2k21.common.pattern.tree.date18012023;

public class MergeTwoBinaryTrees617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return null;
        }

        if(root1 == null) {
            return root2;
        }

        if(root2 == null) {
            return root1;
        }

        //Both Not null
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));

        MergeTwoBinaryTrees617 sol = new MergeTwoBinaryTrees617();
        System.out.println(sol.mergeTrees(root1, root2));
    }
}
