package year2k21.common.pattern.linkedlist;

/**
 * Optimized to use one of existing nodes as output
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode outputHead = l1;//Output is using L1 node.If L2.size > l1.size, Once l1 ends, traverse l2 and add to end of l1 link
        ListNode previousNodeInOutput = null;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int addValue = l1.val + l2.val + carry;
            l1.val = (addValue > 9) ? (addValue - 10) : addValue;
            carry = (addValue > 9) ? 1 : 0;
            previousNodeInOutput = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode remainingList = (l1 != null) ? l1 : l2;
        previousNodeInOutput.next = remainingList;

        while (remainingList != null) {
            int addValue = remainingList.val + carry;
            remainingList.val = (addValue > 9) ? (addValue - 10) : addValue;
            carry = (addValue > 9) ? 1 : 0;
            previousNodeInOutput = remainingList;
            remainingList = remainingList.next;
        }

        if(carry == 1) {
            previousNodeInOutput.next = new ListNode(1, null);
        }

        return outputHead;
    }

    public static void main(String[] args) {
        /*ListNode listNode3 = new ListNode(9, null);
        ListNode listNode2 = new ListNode(4, listNode3);
        ListNode listNode1 = new ListNode(2, listNode2);


        ListNode listNode33 = new ListNode(9, null);
        ListNode listNode22 = new ListNode(6, listNode33);
        ListNode listNode11 = new ListNode(5, listNode22);

        System.out.println(new AddTwoNumbers2().addTwoNumbers(listNode1, listNode11));*/
    }
}
