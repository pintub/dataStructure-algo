package year2k21.common.pattern.linkedlist;

/**
 * https://leetcode.com/problems/rotate-list/
 *
 * Optimization done if k is greater than list size
 *     1. Change links only once, when end is at k-distance away from start
 *     2. If k is greater than list size, and (end = null) is reached before (count <=k) reached ,
 *      Reset k as k = k % length
 *      &
 *      Count is reset
 */
public class RotateList61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }

        ListNode start = head;
        ListNode end = head;
        int count = 1;

        while (count <= k) {//Traverse till end-node is at k distance from start-node
            if(end.next == null) {
                int length = count;
                k = k % length;//k & count is reset
                count = 1;
                end = start;
            } else {
                count++;
                end = end.next;
            }
        }

        while (end.next != null) {
            end = end.next;
            start = start.next;
        }

        end.next = head;
        ListNode newHead = start.next;
        start.next = null;

        return newHead ;
    }

    public static void main(String[] args) {
        /*ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        System.out.println(new RotateList61().rotateRight(listNode1, 2));*/

        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        System.out.println(new RotateList61().rotateRight(listNode1, 8));
    }

}
