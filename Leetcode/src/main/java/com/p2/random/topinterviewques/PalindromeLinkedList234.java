package com.p2.random.topinterviewques;

public class PalindromeLinkedList234 {
    ListNode temp = new ListNode();

    public boolean isPalindrome(ListNode head) {
        temp.next = head;
        return recursion(head);
    }

    boolean recursion(ListNode node) {
        if (node == null) {
            return true;
        }

        if (!recursion(node.next)) {
            return false;
        }
        temp = temp.next;
        return node.val == temp.val;
    }

    public static void main(String[] args) {
        PalindromeLinkedList234 sol = new PalindromeLinkedList234();
        sol.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
    }

    private static class ListNode {
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
    }
}
