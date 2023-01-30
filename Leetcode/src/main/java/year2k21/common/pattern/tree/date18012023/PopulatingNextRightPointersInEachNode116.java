package year2k21.common.pattern.tree.date18012023;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode116 {

    /**
     * Recursion approach expected from Question
     * Could not solve, saw solution
     */
    public Node connect(Node root) {
        connectRecur(root);

        return root;
    }

    private void connectRecur(Node root) {
        if(root == null) {
            return;
        }

        //Notice Null checks, .next assignment is intuitive
        if(root.left != null)
            root.left.next = root.right;
        if(root.right != null && root.next != null)
            root.right.next = root.next.left;

        connectRecur(root.left);
        connectRecur(root.right );
    }

    /**
     * Aux space = O(n), But Question asks to use constant space
     */
    public Node connect_UsingLevelOrder(Node root) {
        if(root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int tempSize = queue.size();
            Node previousNodeOfSameLevel = null;
            for(int count = 1; count <= tempSize; count++) {
                Node currentNode = queue.poll();
                if(count == tempSize) {
                    currentNode.next = null;
                } else if(count == 1) {
                    previousNodeOfSameLevel = currentNode;
                } else {
                    previousNodeOfSameLevel.next = currentNode;
                }
                if(currentNode.left != null)
                    queue.add(currentNode.left);
                if(currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
