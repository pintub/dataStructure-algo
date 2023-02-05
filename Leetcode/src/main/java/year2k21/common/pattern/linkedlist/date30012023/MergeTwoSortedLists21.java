package year2k21.common.pattern.linkedlist.date30012023;

import year2k21.common.pattern.linkedlist.ListNode;

public class MergeTwoSortedLists21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        if(list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(new MergeTwoSortedLists21().mergeTwoLists(first, second));
    }
}
