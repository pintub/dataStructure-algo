package year2k21.common.pattern.tree.date18012023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//1st node

        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int tempSize = queue.size();
            for(int temp = 1; temp <= tempSize; temp++) {
                TreeNode currentNode = queue.poll();

                levelNodes.add(currentNode.val);

                if(currentNode.left != null)
                    queue.add(currentNode.left);
                if(currentNode.right != null)
                    queue.add(currentNode.right);
            }
            result.add(levelNodes);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeLevelOrderTraversal102().levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

}
