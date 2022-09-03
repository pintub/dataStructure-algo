package year2k21.common.pattern.linkedlist;

/**
 * Previous pointer & current pointer
 */
public class RemoveDuplicatesFromSortedList83 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode previousPtr = null;
        ListNode currPtr = head;

        while (currPtr != null) {
            if(previousPtr != null && currPtr.val == previousPtr.val) {//Delete Current Pointer
                    previousPtr.next = currPtr.next;
            } else {
                previousPtr = currPtr;
            }
            currPtr = currPtr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(3, null);
        ListNode listNode4 = new ListNode(3, listNode5);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(1, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(new RemoveDuplicatesFromSortedList83().deleteDuplicates(listNode1));//[1,2,3]

        /*ListNode listNode3 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(1, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(new RemoveDuplicatesFromSortedList83().deleteDuplicates(listNode1));//[1,2]*/

        /*ListNode listNode1 = new ListNode(1, null);
        System.out.println(new RemoveDuplicatesFromSortedList83().deleteDuplicates(listNode1));//[1]*/
    }
}
