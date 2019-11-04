import java.util.*;

/*
// Definition for a Node.

*/
class Codec {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node = new Node(5);
        Node node1 = new Node(6);
        Node node2 = new Node(3);
        node2.children.addAll(Arrays.asList(node, node1));
        root.children.addAll(Arrays.asList(node2, new Node(2), new Node(4)));
        System.out.println(new Codec().serialize(root));
//        Node deserialize = new Codec().deserialize("1[3[5 6] 2 4]");
    }

    public String serialize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(Node root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.children.size() > 0) {
            sb.append(" [");
            for (Node child : root.children)
                serializeHelper(child, sb.append(" "));
            sb.append(" ]");
        }
    }

    public Node deserialize(String data) {
        if (data == null || data.length() < 1) return null;
        String[] nodes = data.split(" ");
        Deque<Node> stack = new LinkedList<>();
        Node curr = new Node(Integer.valueOf(nodes[0]), new LinkedList<>()), parent = curr;

        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i].equals("[")) {
                stack.push(curr);
            } else if (nodes[i].equals("]")) {
                parent = stack.pop();
            } else {
                curr = new Node(Integer.valueOf(nodes[i]), new LinkedList<>());
                stack.peek().children.add(curr);
            }
        }
        return parent;
    }

    static class Node {
        public int val;
        public List<Node> children = new ArrayList<>();

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    ;
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));