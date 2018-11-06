import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = solution.new ListNode(3);
        ListNode l2 = solution.new ListNode(3);

        System.out.print(solution.addTwoNumbers(l1, l2).val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = null;
        while(l1.next != null){
            int result = l1.val + l2.val;
            out = getListNode(out, result);
            l1 = l1.next;
            l2 = l2.next;
        }
        int result = l1.val + l2.val;
        out = getListNode(out, result);
        return  out;
    }

    private ListNode getListNode(ListNode out, int result) {
        if (result >= 10){
            out = new ListNode(result / 10);
            ListNode listNode = new ListNode(result % 10);
            listNode.next = out;
            out = listNode;
        }else {
            out = new ListNode(result);
        }
        return out;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}