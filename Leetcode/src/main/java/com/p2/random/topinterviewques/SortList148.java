package com.p2.random.topinterviewques;

public class SortList148 {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode start) {
        if(start.next == null) {//single element
            return start;
        }
        ListNode middleNode = findMiddleNode(start);//O(n/2)
        ListNode temp = middleNode.next;
        middleNode.next = null;

        ListNode startList1 = mergeSort(start);
        ListNode startList2 = mergeSort(temp);

        return merge(startList1, startList2);
    }

    private ListNode merge(ListNode start1, ListNode start2) {
        if(start1 == null && start2 == null)
            return null;
        if(start1 == null)
            return start2;
        if(start2 == null)
            return start1;
        if(start1.val <= start2.val) {
            start1.next = merge(start1.next, start2);
            return start1;
        } else  {
            start2.next = merge(start1, start2.next);
            return start2;
        }
    }

    private ListNode findMiddleNode(ListNode start) {
        ListNode slowPtr = start;
        ListNode fastPtr = start;
        while (slowPtr.next != null &&
                fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }

    public static void main(String[] args) {
        SortList148 sol = new SortList148();
        ListNode listNode = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        //ListNode listNode = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        System.out.println(sol.sortList(listNode));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }
}
