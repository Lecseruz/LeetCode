import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(2);
//        treeNode.left.right.left = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(1);
        treeNode1.right = new TreeNode(2);

        System.out.println(solution.isSubtree(treeNode, treeNode1));
    }

    HashSet<String> trees = new HashSet<>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }

    public String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#" + t.val + " " + preorder(t.left, true) + " " + preorder(t.right, false);
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
