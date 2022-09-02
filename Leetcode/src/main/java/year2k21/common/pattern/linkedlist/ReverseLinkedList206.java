package year2k21.common.pattern.linkedlist;

import java.util.*;

/**
 * In recursion challenge :
 *  1>
 *      1 -> 2->3 ->4 -> 5
 *      If call-stack at 2, and assume you get reversed list(5->4->3) from child recursion call, you have to traverse till end of reversed-list and add 2, which is not optimized. So return always the last node of reversed list
 *  2>
 *       Another challenge how to return head of reversed-list, "reverseListHead" piggy-back variable solves this
 *  Space = O(n) due to call-stacks
 *
 * Optimized Solution With Tail recursion & Not need of global var (https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution):
 *      Keep a reverseListHead parameter for recursion, and keeping updating like [1-> null] Then [2->1->null] Then [3->2->1->null]
 *      Space = O(1)
 *
 *  Iteration:
 *      Could not solve
 *      No need of stack
 *      Same concept as above leetcode recursion solution
 *      Keep a reverseListHead Var, and keeping updating like [1-> null] Then [2->1->null] Then [3->2->1->null]
 *
 */
public class ReverseLinkedList206 {

    private static ListNode reverseListHead = null;

    //Time = O(n), Space = O(n)
    //Not optimized
    public ListNode reverseListRecursion(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode result =  reverseListRecursion(head.next);

        head.next = null;//Make current node detached from next nodes

        if(result != null) {
            result.next = head;
            return result.next;
        }else {
            result = head;
            reverseListHead = result;
            return result;
        }
    }

    //Time = O(n), Space = O(1)
    public ListNode reverseListIterationNotUsingStack(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode reverseListHead = null;

        while (head != null) {//O(n)
            ListNode next = head.next;
            head.next = reverseListHead;
            reverseListHead = head;
            head = next;
        }

        return reverseListHead;
    }

    //Time = O(2*n), Space = O(n)
    public ListNode reverseListIterationUsingStack(ListNode head) {
        if(head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {//O(n)
            ListNode next =head.next;
            head.next = null;//Make current node detached from next nodes
            stack.push(head);
            head = next;
        }

        ListNode reverseListHead = stack.pop();
        head = reverseListHead;

        for (int count = stack.size() - 1; count >= 0; count--) {//O(n)
            head.next = stack.pop();
            head = head.next;
        }

       return reverseListHead;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        /*new ReverseLinkedList206().reverseListRecursion(listNode1);
        System.out.println(reverseListHead);*/

        //System.out.println(new ReverseLinkedList206().reverseListIterationUsingStack(listNode1));

        System.out.println(new ReverseLinkedList206().reverseListIterationNotUsingStack(listNode1));
    }
}
