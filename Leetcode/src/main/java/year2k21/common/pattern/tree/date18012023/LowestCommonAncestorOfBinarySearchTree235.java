package year2k21.common.pattern.tree.date18012023;

public class LowestCommonAncestorOfBinarySearchTree235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if((root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val)) {
            return root;
        } else if(root.val > p.val && root.val > q.val){ //Shift root to left
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){ //Shift root to right
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
    }

}
