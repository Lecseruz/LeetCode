/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = node;
        node.right = new TreeNode(2);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(4);
        Solution solution = new Solution();
        solution.addOneRow(node, 5, 4);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        f(root, v, d, 1);
        return root;
    }

    void f(TreeNode node, int value, int d, int k) {
        if (node == null) {
            return;
        }
        if(d == 1){
            TreeNode tmp = node;
            node = new TreeNode(value);
            node.left = tmp;
            return;
        }
        if (d - 1 == k) {
            TreeNode tmp = node.left;
            node.left = new TreeNode(value);
            node.left.left = tmp;
            tmp = node.right;
            node.right = new TreeNode(value);
            node.right.right = tmp;
        } else
        {
            f(node.left, value, d, k + 1);
            f(node.right, value, d, k + 1);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}