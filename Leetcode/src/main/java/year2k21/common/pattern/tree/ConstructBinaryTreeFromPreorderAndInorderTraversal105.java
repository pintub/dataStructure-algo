package year2k21.common.pattern.tree;

/**
 * Big Note : To Future Me: You can not understand this code, so stop trying
 * What is used:
 * Recursion
 * Instead of splitting inorder array , used indexing in subsequent recursive calls
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preorderStartIndex, int[] inorder
            , int inorderStartIndex, int inorderEndIndex){
        if(inorderStartIndex == inorderEndIndex)//One element to be processed
            return new TreeNode(preorder[preorderStartIndex]);

        if(preorderStartIndex > preorder.length - 1 || inorderEndIndex > preorder.length - 1
                || inorderStartIndex > inorderEndIndex)
            return null;

        int rootVal = preorder[preorderStartIndex];
        int index = getRootValIndexFromInOrder(inorder, rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, preorderStartIndex + 1, inorder
                , inorderStartIndex, index - 1); // Instead of splitting inOrder using indexing
        int leftSidePartitionSizeOfInOrder =    (index - 1) - inorderStartIndex + 1;//TODO Tricky Part .Alternative is use preorderStartIndex as class-level variable and increment only when a root node is formed
        root.right = buildTree(preorder, preorderStartIndex + leftSidePartitionSizeOfInOrder + 1
                , inorder, index + 1, inorderEndIndex);

        return root;
    }

    private int getRootValIndexFromInOrder(int[] inorder, int val) {
        int result = -1;
        for(int index = 0; index < inorder.length ; ++index) {
            if(inorder[index] == val)
                result = index;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new ConstructBinaryTreeFromPreorderAndInorderTraversal105().buildTree(new int[]{-1},
                new int[]{-1});
        System.out.println(node);
    }
}
