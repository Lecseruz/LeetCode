import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode nodeA = headA;
        while(nodeA != null){
            set.add(nodeA);
            nodeA = nodeA.next;
        }
        ListNode nodeB = headB;
        while(nodeB != null){
            if(set.contains(nodeB))
                return nodeB;
            nodeB = nodeB.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
