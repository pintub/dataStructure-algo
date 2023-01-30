package year2k21.common.pattern.tree.date18012023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Note & Solution {{@link year2k21.common.pattern.tree.SerializeAndDeserializeBinaryTree297}}
 *
 * PreOrder can be used as we are storing nulls
 *
 * Other question need PreOrder + InOrder as list were not storing null, if you store null preorder is sufficient
 */
public class SerializeAndDeserializeBinaryTree297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);

        return sb.substring(1);
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(",X");
            return;
        }

        sb.append(",").append(root.val);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return recursion(queue);
    }

    private TreeNode recursion(Queue<String> queue) {
        String currentElement = queue.poll();
        if("X".equals(currentElement)){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(currentElement));
        node.left = recursion(queue);
        node.right = recursion(queue);

        return node;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree297 sol = new SerializeAndDeserializeBinaryTree297();

        //System.out.println(sol.serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)))));

        System.out.println(sol.serialize(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)))));
        System.out.println(sol.serialize(sol.deserialize("1,X,2,X,3,X,X")));
    }
}
