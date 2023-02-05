package year2k21.common.pattern.linkedlist.date30012023;

import year2k21.common.pattern.linkedlist.ListNode;

public class ReverseLinkedList206 {

    public ListNode reverseList(ListNode head) {
        //return reverseListIteration(head);
        return reverseListRecursion(null, head);
    }

    //Type-2 Recursion
    private ListNode reverseListRecursion(ListNode previousNode, ListNode currentNode) {
        if(currentNode == null)
            return previousNode;

        ListNode nextNode = currentNode.next;
        currentNode.next = previousNode;
        previousNode = currentNode;

        return reverseListRecursion(previousNode, nextNode);
    }

    private ListNode reverseListIteration(ListNode head) {
        if(head == null)
            return null;

        ListNode previousNode = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = previousNode;
            previousNode = temp;
        }
        return previousNode;
    }

    public static void main(String[] args) {
        ReverseLinkedList206 sol = new ReverseLinkedList206();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        System.out.println(sol.reverseList(listNode));
    }
}
