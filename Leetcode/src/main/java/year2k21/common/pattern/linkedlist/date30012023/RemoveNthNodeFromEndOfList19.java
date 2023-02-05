package year2k21.common.pattern.linkedlist.date30012023;

import year2k21.common.pattern.linkedlist.ListNode;

public class RemoveNthNodeFromEndOfList19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode dummy = new ListNode(-1, head);
        ListNode firstPointerPrevNode = dummy;
        ListNode firstPointerCurrNode = head;

        while(count < n) {
            head = head.next;
            count++;
        }

        while(head.next != null) {
            head = head.next;
            firstPointerPrevNode = firstPointerCurrNode;
            firstPointerCurrNode = firstPointerCurrNode.next;
        }

        firstPointerPrevNode.next = firstPointerCurrNode.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList19 sol = new RemoveNthNodeFromEndOfList19();
        System.out.println(sol.removeNthFromEnd(new ListNode(1,new ListNode(2)), 1));
    }
}
