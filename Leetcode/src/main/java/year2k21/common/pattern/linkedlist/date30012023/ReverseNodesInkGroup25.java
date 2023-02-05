package year2k21.common.pattern.linkedlist.date30012023;

import year2k21.common.pattern.linkedlist.ListNode;

public class ReverseNodesInkGroup25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode headTemp = head;
        int len = findLength(headTemp);

        int numberOfReverse = len / k;

        ListNode dummy = new ListNode(-1, head);

        ListNode previousNode = null;
        ListNode previousNodeTemp = dummy;
        ListNode currentNodeTemp = head;

        for(int count = 0; count < numberOfReverse; count++){
            for(int groupNodeCount = 1; groupNodeCount <= k; groupNodeCount++) {
                ListNode temp = head;
                head = head.next;
                temp.next = previousNode;
                previousNode = temp;
            }
            previousNodeTemp.next = previousNode;
            currentNodeTemp.next = head;
            previousNodeTemp = currentNodeTemp;
            currentNodeTemp = currentNodeTemp.next;
            previousNode = null;
        }

        return dummy.next;
    }

    private int findLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        ReverseNodesInkGroup25 sol = new ReverseNodesInkGroup25();
        System.out.println(sol.reverseKGroup(new ListNode(1), 1));
    }
}
