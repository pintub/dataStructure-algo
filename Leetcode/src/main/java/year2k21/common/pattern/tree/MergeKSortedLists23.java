package year2k21.common.pattern.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists23 {

    /**
     * Approach 3
     *  Exactly same as merge() of merge sort
     *  Build Heap of 1st elem of each linked list , SO heap size always = O(k)
     *  Delete minimum of k numbers, for every deletion node add next node of the deleted node
     *
     *  nlog(k)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        ListNode result = null;
        ListNode resultFirstNode = null;

        List<ListNode> initialNotNullNodes = new ArrayList<>();//Stores 1st elem of each linked list
        for(ListNode listNode : lists){
            if(listNode != null)
                initialNotNullNodes.add(listNode);
        }

        //Build Tree O(k) or O(notNullListNodes)
        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(listNode -> listNode.val));
        minHeap.addAll(initialNotNullNodes);

        while (!minHeap.isEmpty()){
            ListNode removed = minHeap.remove();
            if(result == null) {
                resultFirstNode = new ListNode(removed.val);
                result = resultFirstNode;
            } else {
                result.next = new ListNode(removed.val);
                result = result.next;
            }

            if(removed.next != null)
                minHeap.add(removed.next);
        }

        return resultFirstNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));
        System.out.println(new MergeKSortedLists23().mergeKLists(new ListNode[]{node1, node2, node3}));
    }

}
