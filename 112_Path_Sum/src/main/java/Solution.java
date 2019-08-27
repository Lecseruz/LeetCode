public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(-2);
//        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
//        treeNode.left.left = new TreeNode(11);
//        treeNode.right.left = new TreeNode(13);
//        treeNode.right.right = new TreeNode(4);
//        treeNode.left.left.left = new TreeNode(7);
//        treeNode.left.left.right = new TreeNode(2);
//        treeNode.right.right.right = new TreeNode(1);

        System.out.println(solution.hasPathSum(treeNode, -2));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if (root.left == null && root.right == null)
            return sum - root.val == 0;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
