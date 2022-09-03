package year2k21.common.pattern.linkedlist;

/**
 * First Meet using slow(jumps 1 step)/fast(jumps 2 step) pointer
 * Then walk one step each, by putting onePtr at head and otherPtr at meeting point
 */
public class LinkedListCycleII142 {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode firstPtr = head;
        ListNode secondPtr = head;

        while (secondPtr != null && secondPtr.next != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next.next;
            if(firstPtr == secondPtr) {
                break;
            }
        }

        if(firstPtr != secondPtr) {//no cycle
            return null;
        }

        firstPtr = head;
        while (firstPtr != secondPtr){
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        return firstPtr;
    }

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        listNode4.next = listNode2;

        ListNode result = new LinkedListCycleII142().detectCycle(listNode1);

        System.out.println( result == null ? null : result.val);
    }
}
