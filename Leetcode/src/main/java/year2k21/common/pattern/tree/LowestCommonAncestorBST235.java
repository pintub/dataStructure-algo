package year2k21.common.pattern.tree;

public class LowestCommonAncestorBST235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if((root.val >= p.val && root.val <= q.val)
            || (root.val >= q.val && root.val <= p.val))
            return root;

        if(root.val < p.val && root.val < q.val) //go right
            return lowestCommonAncestor(root.right, p, q);

        return lowestCommonAncestor(root.left, p, q);
    }
}
