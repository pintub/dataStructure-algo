package year2k21.common.pattern.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Using "level order"
 * Notice the problem carefully
 * 1---2---4---5---null
 * |   |   |   |
 * nul nul nul nul
 *
 * serialize is 1 null 2 null 4 null 5 , not 1 null 2 null null ...
 *
 * Also last level not nulls there
 *
 * BIG NOTE : Don't refer this, rather refer pre-order solution {{@link  year2k21.common.pattern.tree.date18012023.SerializeAndDeserializeBinaryTree297}}
 */
public class SerializeAndDeserializeBinaryTree297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.remove();
            if(currNode != null) {
                queue.add(currNode.left);
                queue.add(currNode.right);
                if(sb.length() == 0) {
                    sb.append(currNode.val);
                } else {
                    sb.append("/").append(currNode.val);
                }
            } else {
                sb.append("/").append("N");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;

        String[] strings = data.split("/");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        queue.add(root);

        int currIndex = 1;
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.remove();
            if(currNode != null) {
                String leftNodeVal = strings[currIndex];
                if(!"N".equals(leftNodeVal)){
                    currNode.left = new TreeNode(Integer.parseInt(leftNodeVal));
                    queue.add(currNode.left);
                }
                ++currIndex;
                String rightNodeVal = strings[currIndex];
                if(!"N".equals(rightNodeVal)){
                    currNode.right = new TreeNode(Integer.parseInt(rightNodeVal));
                    queue.add(currNode.right);
                }
                ++currIndex;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(5, null, node2);
        TreeNode node4 = new TreeNode(4, null, node3);
        TreeNode root = new TreeNode(1, null, node4);
        String serialize =  new SerializeAndDeserializeBinaryTree297().serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = new SerializeAndDeserializeBinaryTree297().deserialize(serialize);
        System.out.println(deserialize);
    }
}
