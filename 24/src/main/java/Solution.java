import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args)
    {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        Solution solution = new Solution();
        solution.swapPairs(listNode);
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode pre;
        ListNode post;
        ListNode node = head;
        post = node.next.next;
        pre = node.next;
        pre.next = node;
        node.next = post;
        node = node.next;
        head = pre;
        pre = pre.next;
        while(node != null && node.next != null){
            pre.next = node.next;
            post = node.next.next;
            pre = node.next;
            pre.next = node;
            node.next = post;
            node = node.next;
            pre = pre.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}