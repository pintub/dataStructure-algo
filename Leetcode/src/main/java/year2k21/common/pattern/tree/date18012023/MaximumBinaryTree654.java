package year2k21.common.pattern.tree.date18012023;

public class MaximumBinaryTree654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
            return null;

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int startIdx, int endIdx) {
        if(startIdx > endIdx)
            return null;

        if(endIdx >= nums.length || startIdx < 0) //Invalid Idx
            return null;

        int index = findMaxElementIndex(nums, startIdx, endIdx);

        TreeNode newNode = new TreeNode(nums[index]);
        newNode.left = constructMaximumBinaryTree(nums, startIdx, index - 1);
        newNode.right = constructMaximumBinaryTree(nums, index + 1, endIdx);

        return newNode;
    }

    private int findMaxElementIndex(int[] nums, int startIdx, int endIdx) {
        int maxElementIndex = -1;
        for(int index = startIdx; index <= endIdx; index++){
            if(maxElementIndex == -1 || nums[maxElementIndex] < nums[index]) {
                maxElementIndex = index;
            }
        }

        return maxElementIndex;
    }
}
