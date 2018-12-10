/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
class Solution
{
    public static void main(String[] args)
    {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        solution.reverseKGroup(listNode, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k)
    {
        if (head == null)
        {
            return null;
        }
        if (head.next == null)
        {
            return head;
        }
        if(isEnd(head, k -1)){
            return head;
        }
        ListNode pre = null;
        ListNode post;
        ListNode node = head;
        post = getPost(node, k);
        node = revere(node, k);
        ListNode last = getLastNode(node, k);
        last.next = post;
        pre = getPre(node, k);
        head = node;
        if (post == null)
        {
            return head;
        }
        while (!isEnd(pre, k))
        {
            post = getPost(node, k * 2);
            node = revere(pre.next, k);
            last = getLastNode(node, k);
            pre.next = node;
            last.next = post;
            pre = getPre(node, k);
            if (post == null)
            {
                break;
            }
        }
        return head;
    }

    private boolean isEnd(ListNode pre, int k)
    {
        for (int i = 1; i <= k; ++i){
            if(pre == null){
                return true;
            }
            pre = pre.next;
        }
        return pre == null;
    }

    public ListNode getLastNode(ListNode listNode, int k)
    {
        for (int i = 1; i < k; ++i)
        {
            listNode = listNode.next;
        }
        return listNode;
    }

    private ListNode getPre(ListNode head, int k)
    {
        for (int i = 1; i < k; ++i)
        {
            head = head.next;
        }
        return head;
    }

    public ListNode getPost(ListNode head, int k)
    {
        for (int i = 0; i < k; ++i)
        {
            if (head == null)
            {
                return null;
            }
            head = head.next;
        }
        return head;
    }

    public ListNode revere(ListNode listNode, int k)
    {
        if (listNode == null)
        {
            return null;
        }
        if (listNode.next == null)
        {
            return listNode;
        }
        ListNode pre = listNode;
        ListNode node = listNode.next;
        ListNode post = node.next;
        for (int i = 0; i < k -1 ; ++i)
        {
            node.next = pre;
            pre = node;
            node = post;
            if (post != null)
            {
                post = post.next;
            }
        }
        return pre;
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