import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.

*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    void postOrder(Node node, List<Integer> list) {
        if (node == null)
            return;
        for (Node childNode : node.children) {
            postOrder(childNode, list);
        }
        list.add(node.val);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}