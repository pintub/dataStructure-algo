package year2k21.common.pattern.linkedlist.date30012023;

import year2k21.common.pattern.linkedlist.ListNode;

public class OddEvenLinkedList328 {

    public ListNode oddEvenList(ListNode head) {
        int count = 0;
        ListNode evenListHead = new ListNode(-1); //Dummy
        ListNode evenListCurrentPointer = evenListHead;

        ListNode oddListHead = new ListNode(-1);//Dummy
        ListNode oddListCurrentPointer = oddListHead;

        while(head != null) {
            if(count%2 == 0) {//Even
                evenListCurrentPointer.next = head;
                head = head.next;
                evenListCurrentPointer = evenListCurrentPointer.next;
            } else { //Odd
                oddListCurrentPointer.next = head;
                head = head.next;
                oddListCurrentPointer = oddListCurrentPointer.next;
                oddListCurrentPointer.next = null;
            }

            count++;
        }

        evenListCurrentPointer.next= oddListHead.next;

        return evenListHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        OddEvenLinkedList328 sol = new OddEvenLinkedList328();
        System.out.println(sol.oddEvenList(listNode));
    }
}
