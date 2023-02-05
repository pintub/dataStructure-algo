package year2k21.common.pattern.linkedlist.date30012023;

import year2k21.common.pattern.linkedlist.ListNode;

public class SwapNodesInPairs24 {

    public ListNode swapPairs(ListNode head) {
        return swapPairsRecursion(head, 0);
    }

    ListNode swapPairsRecursion(ListNode head, int counter) {
        if(head == null)
            return null;
        boolean isEven = counter % 2 == 0;
        ListNode temp = swapPairsRecursion(head.next, ++counter);
        if(isEven && temp != null) {
            ListNode tempNext = temp.next;
            temp.next = head;
            head.next = tempNext;
            return temp;
        } else {
            head.next = temp;
            return head;
        }
    }
}
