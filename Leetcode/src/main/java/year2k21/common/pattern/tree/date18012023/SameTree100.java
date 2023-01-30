package year2k21.common.pattern.tree.date18012023;

public class SameTree100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        return p.left.val == p.right.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
