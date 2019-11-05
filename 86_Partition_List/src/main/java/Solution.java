class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(2);
//        listNode.next.next.next = new ListNode(2);
//        listNode.next.next.next.next = new ListNode(5);
//        listNode.next.next.next.next.next = new ListNode(2);
        solution.partition(listNode, 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode first = head;
        ListNode prefirst = null;
        if (head == null || head.next == null)
            return head;
        while (first.next != null && first.val < x) {
            prefirst = first;
            first = first.next;
        }
        ListNode second = first;
        while (second != null && second.next != null) {
            if (second.next.val < x) {
                if (prefirst == null) {
                    head = second.next;
                    ListNode secondTmp = second.next.next;
                    prefirst = head;
                    prefirst.next = first;
                    second.next = secondTmp;
                } else {
                    ListNode secondTmp = second.next.next;
                    prefirst.next = second.next;
                    prefirst.next.next = first;
                    second.next = secondTmp;
                    prefirst = prefirst.next;
                }
            } else {
                second = second.next;
            }
        }
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