package year2k21.common.pattern.heap.date24012023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/***
 * Read {@link year2k21.common.pattern.tree.MergeKSortedLists23}
 */
public class MergeKSortedLists23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) {
            return null;
        }

        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(listNode -> listNode.val)); //Q of ListNode

        Arrays.stream(lists).filter(Objects::nonNull).forEach(minHeap::add);//Build Heap O(k)

        ListNode result = null; //Using Auxiliary space
        ListNode resultCurrentNode = null;

        while (!minHeap.isEmpty()) { //O(#Elementslogk)
            ListNode removed = minHeap.remove();
            ListNode newNode = new ListNode(removed.val);

            if (resultCurrentNode == null) {
                result = newNode;
                resultCurrentNode = newNode;
            } else {
                resultCurrentNode.next = newNode;
                resultCurrentNode = resultCurrentNode.next;
            }

            if(removed.next == null)
                continue;
            minHeap.add(removed.next);
        }

        return result;
    }

    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        MergeKSortedLists23 sol= new MergeKSortedLists23();
        System.out.println(sol.mergeKLists(new ListNode[]{null}));*/

        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(6)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(5)));

        System.out.println(MergeKSortedLists23.merge(l1, l2));
    }

    static class ListNode {

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

    //This function is from Merge Two Sorted Lists. No related to this Answer though
    private static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
