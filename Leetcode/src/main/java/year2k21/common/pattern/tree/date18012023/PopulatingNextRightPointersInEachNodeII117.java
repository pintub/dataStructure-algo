package year2k21.common.pattern.tree.date18012023;

/**
 * Not a Perfect Binary Tree
 */
public class PopulatingNextRightPointersInEachNodeII117 {

    public Node connect(Node root) {
        connectRecur(root);
        
        return root;
    }

    public Node connectRecur(Node root) {
        if (root == null) return null;

        if (root.left != null) { // update left next
            if (root.right != null) root.left.next = root.right; // if right child exists - simple connect left.next to right
            else root.left.next = findNext(root); // if not - scan parent next node until we find the first left or right child
        }
        if (root.right != null) { // update right next
            root.right.next = findNext(root);
        }

        connectRecur(root.right); // TWIST update the right nodes first ? Why ? Because in findNext() you are finding next available parent in chain and get that node's child
        connectRecur(root.left);
        return root;
    }

    private Node findNext(Node root) { // get parent node
        while (root.next != null) { // scan all next parent nodes chain until we find the first left or right child
            root = root.next;
            if (root.left != null) return root.left;
            if (root.right != null) return root.right;
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
