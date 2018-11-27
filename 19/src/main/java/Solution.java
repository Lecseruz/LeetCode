import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 2; ++i) {
            node.next = new ListNode(i);
            node = node.next;
        }
        Solution solution = new Solution();
        solution.removeNthFromEnd(head, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode listNode = head;
        while (listNode != null) {
            ++size;
            listNode = listNode.next;
        }
        if (size == 1){
            return null;
        }
        if(size - n == 0){
            return head.next;
        }
        ListNode preListNode = head;
        for (int i = 0; i < size - n - 1; ++i) {
            preListNode = preListNode.next;
        }
        preListNode.next = preListNode.next.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
