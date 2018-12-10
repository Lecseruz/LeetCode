import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
class Solution
{
    public static void main(String[] args)
    {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(6);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(5);
        listNode3.next = new ListNode(2);
        listNode3.next.next = new ListNode(7);
        Solution solution = new Solution();
        ListNode[] listNodes = new ListNode[1];
        listNodes[0] = null;
//        listNodes[1] = listNode2;
//        listNodes[2] = listNode3;
        solution.mergeKLists(listNodes);
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        if (lists == null){
            return null;
        }
        if(lists.length == 0){
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        Map<Integer, ListNode> map = new HashMap<>();
        PriorityQueue<MetaElement> priorityQueue = new PriorityQueue<>();
        int i = 0;
        for (ListNode listNode : lists)
        {
            if(listNode != null){
                map.put(i, listNode);
                priorityQueue.add(new MetaElement(i, listNode.val));
                ++i;
            }
        }
        while (!priorityQueue.isEmpty())
        {
            MetaElement metaElement = priorityQueue.poll();

            if (map.get(metaElement.id).next != null)
            {
                updateMap(metaElement.id, map);
                priorityQueue.add(new MetaElement(metaElement.id, map.get(metaElement.id).val));
            }
            node.next = new ListNode(metaElement.value);
            node = node.next;
        }
        return head.next;
    }

    private void updateMap(int id, Map<Integer, ListNode> map)
    {
        map.put(id, map.get(id).next);
    }

    public static class MetaElement implements Comparable
    {
        int id;
        Integer value;

        MetaElement(int id, Integer value)
        {
            this.id = id;
            this.value = value;
        }

        @Override
        public int compareTo(Object o)
        {
            MetaElement o1 = (MetaElement) o;
            if(this.value.equals(o1.value)){
                return 0;
            }
            return this.value > o1.value ? 1 : -1;
        }
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