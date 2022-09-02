package year2k21.common.pattern.linkedlist;

/**
 * Extension of {@link year2k21.common.pattern.linkedlist.ReverseLinkedList206}
 *
 * 2 whiles
 *          1 while till you reach left-node
 *          Then next while till you reach right and reverse the list here using {@link year2k21.common.pattern.linkedlist.ReverseLinkedList206}
 *
 *          In both while-loop, have a previous-ptr and current-pointer to get previous-to-left & next-to-right nodes
 */
public class ReverseLinkedListII92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }

        ListNode headCopy = head;

        int count = 1;
        ListNode previousToLeft = null;//Should point to node at left-1

        while (count < left) {//Till Left-1
            count++;
            previousToLeft = head;
            head = head.next;
        }

        ListNode nodeAtLeft = head;
        ListNode reverseListHead = null;

        while (count <= right) {//Till Right
            count++;
            ListNode next = head.next;
            head.next = reverseListHead;
            reverseListHead = head;
            head = next;
        }//At end head points to right+1

        if(previousToLeft != null) {
            previousToLeft.next = reverseListHead;
        }
        if(head != null) {
            nodeAtLeft.next = head;
        }
        return (previousToLeft == null) ? reverseListHead : headCopy;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        System.out.println(new ReverseLinkedListII92().reverseBetween(listNode1, 1, 4));
    }
}
