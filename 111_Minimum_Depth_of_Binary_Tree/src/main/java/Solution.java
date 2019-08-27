import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(52);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(8);
        treeNode.left.right = new TreeNode(10);
//        treeNode.right.left = new TreeNode(20);
//        treeNode.right.right = new TreeNode(14);
        System.out.println(solution.minDepth(treeNode));
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int k = 1;
        while (true) {
            TreeNode node = queue.remove();
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            if(node.left == null && node.right == null)
                return k;
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
