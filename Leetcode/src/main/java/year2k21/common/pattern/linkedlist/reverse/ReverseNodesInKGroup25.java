package year2k21.common.pattern.linkedlist.reverse;

/**
 * Question:
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Solution Discussion :
 * Extension of {@link year2k21.common.pattern.linkedlist.reverse.ReverseLinkedListII92}
 *
 * Create dummy node at the beginning and reverse nodes between start and end (exclusive)
 * Time = O(n + n), 1st O(n) for while loop and 2nd O(n) for n/k times O(k) reversal
 */
public class ReverseNodesInKGroup25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        return iterative(head, k);
    }

    private ListNode iterative(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        int count = 1;
        ListNode start = new ListNode(Integer.MIN_VALUE, head);//Dummy node at the start
        ListNode headCopy = head;
        ListNode newHead = head;

        while (head != null) {
            if(count % k != 0) {
                head = head.next;
            } else {
                ListNode temp = start.next;
                reverse(start, head.next);
                newHead = (newHead == headCopy) ? start.next : newHead;//Set once , then unchanged
                head = temp.next;
                start = temp;
            }
            count++;
        }

        return newHead ;
    }

    //Reverse nodes between start & end node exclusive
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode firstNode = start.next;
        ListNode newHead = null;

        while (firstNode != end) {
            ListNode next = firstNode.next;
            firstNode.next = newHead;
            newHead = firstNode;
            firstNode = next;
        }

        start.next.next = firstNode;
        start.next = newHead;

        return start;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        System.out.println(new ReverseNodesInKGroup25().iterative(listNode1, 3));
    }
}
