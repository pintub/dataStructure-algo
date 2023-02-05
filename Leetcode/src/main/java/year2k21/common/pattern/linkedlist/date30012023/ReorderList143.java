package year2k21.common.pattern.linkedlist.date30012023;

import year2k21.common.pattern.linkedlist.ListNode;

public class ReorderList143 {

    ListNode firstHalfNode;

    public void reorderList(ListNode head) {
        //Find mid node
        firstHalfNode = head;
        ListNode firstPointer = head, secondPointer = head;
        while (firstPointer.next != null && secondPointer.next != null && secondPointer.next.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }

        ListNode nextToMiddlePointer = firstPointer.next;
        firstPointer.next = null;//TODO check this

        insertNodesInBetweenRecursion(nextToMiddlePointer);
    }

    private void insertNodesInBetweenRecursion(ListNode secondHalfNode) {
        if(secondHalfNode == null)
            return;

        insertNodesInBetweenRecursion(secondHalfNode.next);

        ListNode temp = firstHalfNode.next;
        firstHalfNode.next = secondHalfNode;
        secondHalfNode.next = temp;
        firstHalfNode = temp;
    }

    public static void main(String[] args) {
        ReorderList143 sol = new ReorderList143();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        sol.reorderList(listNode);
        System.out.println(listNode);
    }
}
