import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = solution.new ListNode(2);
        ListNode l2 = solution.new ListNode(5);
        l1.next = solution.new ListNode(4);
        l1.next.next = solution.new ListNode(3);
        l2.next = solution.new ListNode(6);
        l2.next.next = solution.new ListNode(4);
        System.out.print(solution.addTwoNumbers(l1, l2).val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head;
        int remainder = 0;
        int result = getValue(l1) + getValue(l2);
        ListNode out;
        if (result >= 10) {
            head = new ListNode((result + remainder) % 10);
            remainder = (result + remainder) / 10;
            out = head;
        } else {
            head = out = new ListNode(result);
        }
        if (l1.next != null || l2.next != null) {
            do {
                l1 = next(l1);
                l2 = next(l2);
                result = getValue(l1) + getValue(l2) + remainder;
                if (result >= 10) {
                    ListNode listNode = new ListNode(result % 10);
                    remainder = result / 10;
                    out.next = listNode;
                    out = listNode;
                } else {
                    ListNode listNode = new ListNode(result % 10);
                    out.next = listNode;
                    out = listNode;
                    remainder = 0;
                }
            }
            while (next(l1) != null || next(l2) != null);
        }
        if (remainder != 0) {
            out.next = new ListNode(remainder);
        }
        return head;
    }

    public ListNode next(ListNode listNode) {
        if (listNode != null) {
            return listNode.next;
        }
        return null;
    }

    public int getValue(ListNode listNode) {
        return listNode == null ? 0 : listNode.val;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}