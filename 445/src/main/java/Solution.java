import static java.lang.Math.max;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
class Solution
{
    public static void main(String[] args)
    {
        ListNode node = new ListNode(7);
        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(9);
        node1.next.next.next = new ListNode(9);
        node1.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next.next.next.next.next = new ListNode(9);
        Solution solution = new Solution();
        solution.addTwoNumbers(node1, node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        String value1 = toString(l1);
        String value2 = toString(l2);
        return toList(sumString(value1, value2));
    }

    public String sumString(String val1, String val2)
    {
        StringBuilder stringBuilder = new StringBuilder();
        int max = max(val1.length(), val2.length());
        int reminder = 0;
        for (int i = 0; i < max; ++i)
        {
            int val = getVal(val1, i) + getVal(val2, i) + reminder;
            if(val / 10 != 0){
                reminder = 1;
                stringBuilder.append(val % 10);
            } else {
                reminder = 0;
                stringBuilder.append(val);
            }
        }
        if(reminder != 0){
            stringBuilder.append(reminder);
        }
        return stringBuilder.reverse().toString();
    }

    private int getVal(String val2, int i)
    {
        if (val2.length() > i)
        {
            return Character.getNumericValue(val2.charAt(i));
        }
        else
        {
            return 0;
        }
    }

    public String toString(ListNode listNode)
    {
        ListNode node = listNode;
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null)
        {
            stringBuilder.append(node.val);
            node = node.next;
        }
        return stringBuilder.reverse().toString();
    }

    public ListNode toList(String val)
    {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 0 ; i < val.length(); ++i){
            node.next = new ListNode(Character.getNumericValue(val.charAt(i)));
            node = node.next;
        }
        return head.next;
    }

    public static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
        }
    }
}