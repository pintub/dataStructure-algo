package year2k21.common.pattern.tree.date18012023;

/**
 * Not a Perfect Binary Tree
 */
public class PopulatingNextRightPointersInEachNodeII117 {

    public Node connect(Node root) {
        connectRecur(root);
        
        return root;
    }

    private void connectRecur(Node root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNext(root.next);
            }
        }
        if(root.right != null) {
            root.right.next = findNext(root.next);
        }

        connectRecur(root.right);//TWIST
        connectRecur(root.left);
    }

    private Node findNext(Node root) {
        while (root != null){
            if(root.left != null)
                return root.left;
            if(root.right != null)
                return root.right;

            root = root.next;
        }
        return null;
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
