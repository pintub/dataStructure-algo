package year2k21.common.pattern.linkedlist;

/**
 * 2 Pointers in LL
 * Special case when head itself is to be removed
 */
public class RemoveNthNodeFromEndOfList19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode firstPtr = head;
        ListNode secondPtr = head;
        int count = 0;

        while (count < n) {//Move secondPtr to keep it at a distance of n from firstPtr
            count++;
            secondPtr = secondPtr.next;
        }

        if(secondPtr == null) {//Special case, Head needs to be removed
            ListNode temp = head.next;
            head.next = null;//Orphan 1st node, will be garbage collected
            head = temp;
            return head;
        }

        while (secondPtr.next != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        ListNode temp = firstPtr.next;
        firstPtr.next = temp.next;
        temp.next = null;//Orphan node, will be garbage collected

        return head;
    }

    public static void main(String[] args) {
        /*ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(new RemoveNthNodeFromEndOfList19().removeNthFromEnd(listNode1, 2));//[1,2,3,5]
        */

        ListNode listNode1 = new ListNode(1, null);
        System.out.println(new RemoveNthNodeFromEndOfList19().removeNthFromEnd(listNode1, 1));//null

        /*ListNode listNode2 = new ListNode(2, null);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(new RemoveNthNodeFromEndOfList19().removeNthFromEnd(listNode1, 1));//[1]*/
    }
}
