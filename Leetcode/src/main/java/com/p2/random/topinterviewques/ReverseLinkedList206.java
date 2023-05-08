package com.p2.random.topinterviewques;

public class ReverseLinkedList206 {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode result = null;
        while (head != null) {
            ListNode currentNode = head;
            head = currentNode.next;
            currentNode.next = result;
            result = currentNode;
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseLinkedList206 sol = new ReverseLinkedList206();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(sol.reverseList(listNode));
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
