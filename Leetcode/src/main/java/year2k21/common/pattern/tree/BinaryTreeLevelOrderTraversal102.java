package year2k21.common.pattern.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){//This line visited for each level once
            queue.add(null);//level breakpoint
            List<Integer> levelNodeList = new ArrayList<>();
            while (queue.peek() != null) {
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null)
                    queue.add(currentNode.left);
                if(currentNode.right != null)
                    queue.add(currentNode.right);
                levelNodeList.add(currentNode.val);
            }
            queue.poll();//Remove null,which is level breakpoint
            result.add(levelNodeList);
        }

        return result;
    }
}
