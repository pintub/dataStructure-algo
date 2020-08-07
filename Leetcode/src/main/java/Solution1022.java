public class Solution1022 {

    public int totalSum = 0;

    public int sumRootToLeaf(TreeNode root) {
        treeTraversal(0, root);
        return totalSum;
    }

    private void treeTraversal(int sum, TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        sum = sum << 1;//LeftShift by 1 bit
        sum += treeNode.val;//Add current number
        if(treeNode.left == null && treeNode.right == null){ //Leaf node
            totalSum += sum;
            return;
        }
        treeTraversal(sum, treeNode.left);
        treeTraversal(sum, treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode lvl_2_1 = new TreeNode(0, null, null);
        TreeNode lvl_2_2 = new TreeNode(1, null, null);
        TreeNode lvl_2_3 = new TreeNode(0, null, null);
        TreeNode lvl_2_4 = new TreeNode(1, null, null);
        TreeNode lvl_1_1 = new TreeNode(0, lvl_2_1, null);
        TreeNode lvl_1_2 = new TreeNode(1, lvl_2_3, null);
        TreeNode root = new TreeNode(1, lvl_1_1, lvl_1_2);
        System.out.println(new Solution1022().sumRootToLeaf(root));
    }
}
