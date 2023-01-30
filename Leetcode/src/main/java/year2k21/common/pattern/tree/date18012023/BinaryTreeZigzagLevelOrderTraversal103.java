package year2k21.common.pattern.tree.date18012023;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Level Order +
 * DeQueue
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean isLeftToTree = true;

        while (!deque.isEmpty()) {
            int tempSize = deque.size();
            List<Integer> levelList = new ArrayList<>();
            for (int count = 1; count <= tempSize; count++) {
                if(isLeftToTree) {
                    TreeNode currentNode = deque.removeFirst();
                    levelList.add(currentNode.val);
                    if(currentNode.left != null )
                        deque.addLast(currentNode.left);
                    if(currentNode.right != null )
                        deque.addLast(currentNode.right);
                } else {
                    TreeNode currentNode = deque.removeLast();
                    levelList.add(currentNode.val);
                    if(currentNode.right != null )
                        deque.addFirst(currentNode.right);
                    if(currentNode.left != null )
                        deque.addFirst(currentNode.left);
                }
            }

            result.add(levelList);
            isLeftToTree = !isLeftToTree;
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal103 sol = new BinaryTreeZigzagLevelOrderTraversal103();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println(sol.zigzagLevelOrder(root));
    }
}
