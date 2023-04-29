package year2k21.common.pattern.general.two.pointer.date17042023;

public class RemoveDuplicatesFromSortedList83 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode firstPtr = head, secondPtr = head.next;

        while (secondPtr != null) {
            if(secondPtr.val == firstPtr.val) {
                //Delete secondPtr node
                firstPtr.next = secondPtr.next;
                secondPtr = secondPtr.next;
            } else {
                firstPtr = secondPtr;
                secondPtr = secondPtr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList83 sol = new RemoveDuplicatesFromSortedList83();
        //ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));//1,2,3
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));//1,2
        System.out.println(sol.deleteDuplicates(head));
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
            return new String(val + "-->" + next);
        }
    }
}
