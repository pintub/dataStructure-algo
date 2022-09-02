package year2k21.common.pattern.linkedlist;

/**
 * Maintain previousToPreviousNode, previousNode, currentNode as these 3 needed for changing pointers
 * This is look-back method
 *
 * or
 *
 * as in swapPairsV2() maintain only previousNode & currentNode . Look up for currentNode & currentNode.next in advance
 * This is look-forward method
 */
public class SwapNodesInPairs24 {

    public ListNode swapPairsV2(ListNode head) {
        if(head == null || head.next == null) {//If single or ZERO node
            return head;
        }
        ListNode currentNode = head;
        ListNode previousNode = null;
        while (currentNode != null && currentNode.next != null) {//Current & next pointer check
            ListNode temp = currentNode.next;
            currentNode.next = currentNode.next.next;
            temp.next = currentNode;
            if( previousNode == null) {
                head = temp;
            } else {
                previousNode.next = temp;
            }


            previousNode = temp.next;//Jump twice
            currentNode = temp.next.next;//Jump twice
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {//If single or ZERO node
            return head;
        }

        ListNode currentNode = head.next;
        ListNode previousNode = head;
        ListNode previousToPreviousNode = null;
        int nodeCount = 1;

        while (currentNode != null) {
            ++nodeCount;
            if(nodeCount % 2 == 0) {
                jugglePointers(previousNode, currentNode);
                ListNode temp = currentNode;
                currentNode = previousNode;
                previousNode = temp;
                if(previousToPreviousNode != null) {
                    previousToPreviousNode.next = previousNode;
                } else {
                    head = previousNode;
                }
            }

            previousToPreviousNode = previousNode;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return  head;
    }

    private void jugglePointers(ListNode previousNode, ListNode currentNode) {
        ListNode temp = currentNode;
        previousNode.next = temp.next;
        currentNode.next = previousNode;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(new SwapNodesInPairs24().swapPairsV2(node1));
    }
}
