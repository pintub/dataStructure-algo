package year2k21.common.pattern.tree.date18012023;

public class KthSmallestElementInBST230 {

    private int counter = 0;
    private boolean kthFound= false;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestRecur(root, k);

        return result;
    }

    private void kthSmallestRecur(TreeNode root, final int k) {
        if(root == null) {
            return;
        }
        if(kthFound) {
            return;
        }

        kthSmallestRecur(root.left, k);
        ++counter;
        if(counter == k) {
            kthFound = true;
            result = root.val;
        }
        kthSmallestRecur(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        KthSmallestElementInBST230 sol = new KthSmallestElementInBST230();
        System.out.println(sol.kthSmallest(root, 3));
    }
}
