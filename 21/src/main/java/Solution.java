/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(4);
        Solution solution = new Solution();
        solution.mergeTwoLists(listNode1, listNode);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null || l2 != null){
            if (l1 == null) {
                node.next = new ListNode(l2.val);
                node = node.next;
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;
                continue;
            }
            if (l1.val >= l2.val){
                node.next = new ListNode(l2.val);
                node = node.next;
                l2 = l2.next;
            } else {
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;
            }
        }
        return head.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}