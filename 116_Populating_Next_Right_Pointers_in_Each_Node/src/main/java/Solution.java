import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        solution.connect(node);
        System.out.println(node.left.next.val);
        System.out.println(node.left.left.next.val);
        System.out.println(node.right.left.next.val);
    }

    // BFS
    public Node connect(Node root)
    {
        if (root == null)
            return null;
        List<Node> list = new ArrayList<>();
        list.add(root);
        List<Node> list2 = new ArrayList<>();
        while (!list.isEmpty())
        {
            for (int i = 0; i < list.size(); ++i)
            {
                Node node = list.get(i);
                if (node == null)
                    continue;
                list2.add(node.left);
                list2.add(node.right);
                if (i < list.size() - 1)
                    node.next = list.get(i + 1);
            }
            list.clear();
            list.addAll(list2);
            list2.clear();
        }
        return root;
    }
    // DFS
//    public Node connect(Node root) {
//        return connect(root, null);
//    }
//
//    public Node connect(Node root, Node rightNode) {
//        if (root == null) {
//            return root;
//        }
//        root.next = rightNode;
//        connect(root.left, root.right);
//        connect(root.right, root.next == null ? null : root.next.left);
//        return root;
//    }
    public static class Node
    {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node()
        {
        }

        public Node(int _val, Node _left, Node _right, Node _next)
        {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public Node(int val)
        {
            this.val = val;
        }
    }
}
