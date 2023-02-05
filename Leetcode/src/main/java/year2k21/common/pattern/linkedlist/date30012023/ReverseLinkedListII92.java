package year2k21.common.pattern.linkedlist.date30012023;

import year2k21.common.pattern.linkedlist.ListNode;

public class ReverseLinkedListII92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null)
            return null;

        ListNode dummy = new ListNode(-600);
        dummy.next = head;
        int count = 0;

        ListNode previousNode = null;
        head = dummy;

        while(head != null && count < left) {
            count++;
            previousNode = head;
            head = head.next;
        }

        ListNode leftOfLeftNode = previousNode;
        ListNode leftNode = head;

        count = 0;
        previousNode = null;
        while (head != null && count <= right - left) {
            count++;
            ListNode temp = head;
            head = head.next;
            temp.next = previousNode;
            previousNode = temp;
        }

        ListNode rightNode = previousNode;
        ListNode rightOfRightNode = head;

        leftOfLeftNode.next = rightNode;
        leftNode.next = rightOfRightNode;


        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII92 sol = new ReverseLinkedListII92();
        ListNode listNode = new ListNode(1);

        System.out.println(sol.reverseBetween(listNode, 1, 1));
    }
}
