package year2k21.common.pattern.linkedlist.date30012023;

import year2k21.common.pattern.linkedlist.ListNode;

public class LinkedListCycle141 {

    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next !=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

}
