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
        int result = l1.val + l2.val;
        ListNode out;
        if (result >= 10){
            head = new ListNode((result + remainder) % 10);
            remainder = (result + remainder) / 10;

            out = head;
        }else {
            head = out = new ListNode(result);
        }
        if(l1.next != null && l2.next != null)
        {
            do
            {
                l1 = l1.next;
                l2 = l2.next;
                result = l1.val + l2.val + remainder;
                if (result >= 10)
                {
                    ListNode listNode = new ListNode(result % 10);
                    remainder = result / 10;
                    out.next = listNode;
                    out = listNode;
                }
                else
                {
                    ListNode listNode = new ListNode(result % 10);
                    out.next = listNode;
                    out = listNode;
                    remainder = 0;
                }
            }
            while (l1.next != null);
        }
        if (remainder != 0){
            out.next = new ListNode(remainder);
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}