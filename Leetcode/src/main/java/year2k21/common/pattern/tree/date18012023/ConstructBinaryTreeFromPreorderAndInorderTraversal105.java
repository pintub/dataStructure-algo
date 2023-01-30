package year2k21.common.pattern.tree.date18012023;

/**
 * Traverse preOrder elements one by one, search that element in inOrder, split inOrder into 2. Recurse steps
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRecursively(0, 0, inorder.length, preorder, inorder);
    }

    private TreeNode buildTreeRecursively(int preOrderIndex, int inOrderStartIndex, int inOrderEndIndex, final int[] preorder, final int[] inorder) {
        if(preOrderIndex >= preorder.length) {
            return null;
        }

        if(inOrderStartIndex > inOrderEndIndex) {
            return null;
        }

        int inOrderFoundIndex = findIndexInInorderArray(preorder[preOrderIndex], inOrderStartIndex, inOrderEndIndex, inorder);

        TreeNode newNode = new TreeNode(preorder[preOrderIndex]);
        newNode.left = buildTreeRecursively(preOrderIndex + 1, inOrderStartIndex, inOrderFoundIndex - 1, preorder, inorder);
        int leftPartSize = inOrderFoundIndex - inOrderStartIndex; //This is the place you might or will go wrong
        newNode.right = buildTreeRecursively(preOrderIndex + leftPartSize + 1, inOrderFoundIndex + 1, inOrderEndIndex, preorder, inorder);

        return newNode;
    }

    private int findIndexInInorderArray(int target, int inOrderStartIndex, int inOrderEndIndex, int[] inorder) {
        for(int index= inOrderStartIndex; index <= inOrderEndIndex; index++) {
            if(target == inorder[index]) {
                return index;
            }
        }
        return -1; //You can not reach me
    }

    public static void main(String[] args) {
        int[] preOrder = new int[] {3,9,20,15,7};
        int[] inOrder = new int[] {9,3,15,20,7};
        ConstructBinaryTreeFromPreorderAndInorderTraversal105 sol = new ConstructBinaryTreeFromPreorderAndInorderTraversal105();

        System.out.println(sol.buildTree(preOrder, inOrder));
    }
}
