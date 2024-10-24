package year2k21.common.pattern.tree.date18012023;

/**
 * 1st Serialize both using PreOrder(Check return statement)  , Then check if Substring
 */
public class SubtreeOfAnotherTree572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String s1 = serialize(root);
        String s2 = serialize(subRoot);

        return s1.contains(s2);
    }

    private String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }

        return "^" + root.val + "," + serialize(root.left) + "," + serialize(root.right) + "$";
    }

    public static void main(String[] args) {
        System.out.println(new SubtreeOfAnotherTree572().isSubtree(new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5)), new TreeNode(4, new TreeNode(1), new TreeNode(2))));
    }
}
