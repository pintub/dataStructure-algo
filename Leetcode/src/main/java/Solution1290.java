import java.util.ArrayList;
import java.util.List;

public class Solution1290 {
    //Int Array instead of ArrayList
    public int getDecimalValueV3(ListNode head) {
        int nodeCount = 0;
        int[] nums = new int[30];
        nums[0] = head.val;
        ListNode node = head;
        while (node.next != null){
            ++nodeCount;
            node = node.next;
            nums[nodeCount] = node.val;
        }

        int output = 0;
        for(int count = nodeCount, count2 = 0 ; count >= 0 ; count--, count2++){
            output += nums[count] * (int)Math.pow(2, count2);
        }
        return output;
    }

    //Leetcode solution
    public int getDecimalValue(ListNode head) {
        int num = 0;                // Initialise num to 0
        while(head!=null) {         // Iterate over the linked list until head is null
            num <<= 1;              // Left shift num by 1 position to make way for next bit
            num += head.val;        // Add next bit to num at least significant position
            head = head.next;       // Update head
        }
        return num;
    }

    //Integer ArrayList
    public int getDecimalValueV2(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        nums.add(head.val);
        ListNode node = head;
        while (node.next != null){
            node = node.next;
            nums.add(node.val);
        }

        int output = 0;
        for(int count = nums.size()-1, digitPlace=0 ; count >= 0 ; count--, digitPlace++){
            output += nums.get(count) * (int)Math.pow(2, digitPlace);
        }
        return output;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(0, null);
        ListNode node4 = new ListNode(1, node5);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(0, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(new Solution1290().getDecimalValue(node1));
    }

}
