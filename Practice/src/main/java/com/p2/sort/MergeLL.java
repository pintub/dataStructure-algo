package com.p2.sort;

import com.p2.linkedlist.ListNode;

public class MergeLL {

    static void sort(ListNode head){
        if(head.getNodeNext() == null){
            return;
        }

        //Split LL
        ListNode middle = getMiddle(head);
        ListNode middleNxt = middle.getNodeNext();
        middle.setNodeNext(null);

        sort(head);
        sort(middleNxt);

        merge(head, middleNxt);
    }

    private static void merge(ListNode head, ListNode middleNxt) {
        //TODO
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode sloPointer = head;
        ListNode fastPointer = head;
        while(fastPointer.getNodeNext() == null || fastPointer.getNodeNext().getNodeNext() == null){
            sloPointer = sloPointer.getNodeNext();
            fastPointer = fastPointer.getNodeNext().getNodeNext();
        }

        return sloPointer.getNodeNext();
    }

}
