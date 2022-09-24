package year2k21.common.pattern.linkedlist;

/**
 * https://leetcode.com/problems/reorder-list/
 *
 * 2 step (Iteration + Recursion)
 * Input : [node1 -> node2 -> node3 -> node4 -> node5]
 *
 * 1st step Iteration : Use slow and fast pointer to find middle node and slow-Pointer = middle-node
 *          By now, Output list is partially formed [1,2,3]
 *
 * 2nd step Recursion:
 *          Intuition : Now we have traverse rest of list(From middle-next-node "node4" location till end-node "node5") and insert nodes the above partially formed list at alternate position, i.e. node5 should go in between node1 and node2 and node4 should go between node3 and node5. So challenge is how to get first node5 then node4, well this can be achieved by recursion. Check usage of "nodePositionToBeInserted" var in recursion
 *
 */
public class ReorderList143 {

    private ListNode nodePositionToBeInserted = null;

    public void reorderList(ListNode head) {//Total = O(n) //Refer below for time complexity components
        if(head.next == null) {
            return;
        }

        ListNode slowPtr = head, fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null){//Bring slow ptr to middle, O(n/2)
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        ListNode nextToMiddleNode = slowPtr.next;
        slowPtr.next = null;

        nodePositionToBeInserted = head;

        recursion(nextToMiddleNode);//O(n/2)
    }

    private void recursion(ListNode node) {
        if(node == null) {
            return;
        }

        recursion(node.next);

        ListNode next = nodePositionToBeInserted.next;
        nodePositionToBeInserted.next = node;
        node.next = null;
        if(next != null) {
            node.next = next;
            nodePositionToBeInserted = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        new ReorderList143().reorderList(listNode1);
        System.out.println(listNode1);
    }
}
