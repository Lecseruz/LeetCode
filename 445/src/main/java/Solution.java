/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
class Solution
{
    public static void main(String[] args)
    {
        ListNode node = new ListNode(9);
        ListNode node1 = new ListNode(1);
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
        int value1 = toFloat(l1);
        int value2 = toFloat(l2);
        return toList(value1 + value2);
    }

    public int toFloat(ListNode listNode){
        Integer integer = listNode.val;
        listNode = listNode.next;
        while(listNode != null){
            integer = integer * 10 + listNode.val;
            listNode = listNode.next;
        }
        return integer;
    }

    public ListNode toList(int val){
        ListNode listNode = new ListNode((val % 10));
        val /= 10;
        while (val != 0) {
            ListNode tmp = new ListNode((int) (val % 10));
            val /= 10;
            tmp.next = listNode;
            listNode = tmp;
        }
        return listNode;
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