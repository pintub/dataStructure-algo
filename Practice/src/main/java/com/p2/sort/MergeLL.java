package com.p2.sort;

import com.p2.linkedlist.ListNode;

/**
 * Suitable for linked-list
 * why
 *  - As QuickSort & HeapSort uses indexing, does not fit for LL
 *  - Mergesort merge() can be in place without auxiliary space in case of linked-list . Proven in merge(). Hey, future
 *  me don't try to understand merge(), rather use pen and paper, it is mostly game of pointers
 *  Tips:
 *      1. mid of list using slow and fast pointer
 */
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(6, null)));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(8, null)));
        merge(l1, l2);
        System.out.println(l1);
    }

    private static void merge(ListNode list1, ListNode list2) {
        //convert list1 to merged list
        if (list1 == null) {
            list1 = list2;
            list2 = null;
            return;
        }

        if (list2 == null)
            return;

        ListNode pointerForSortedPartFromList1 = null;
        ListNode currentPointerFromList1 = list1;
        while (list2 != null && currentPointerFromList1 != null) {
            if ((int) currentPointerFromList1.getNodeValue() <= (int) list2.getNodeValue()) {//List1 current node is smaller
                pointerForSortedPartFromList1 = currentPointerFromList1;
                currentPointerFromList1 = currentPointerFromList1.getNodeNext();
            } else {
                //Delete 1st node from list2 and insert in list1 between pointerForSortedPartFromList1 & currentPointerFromList1
                ListNode temp = list2;
                list2 = list2.getNodeNext();
                temp.setNodeNext(pointerForSortedPartFromList1.getNodeNext());
                pointerForSortedPartFromList1.setNodeNext(temp);
                pointerForSortedPartFromList1 = pointerForSortedPartFromList1.getNodeNext();
            }
        }

        if (list2 != null) {
            pointerForSortedPartFromList1.setNodeNext(list2);
        }
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
