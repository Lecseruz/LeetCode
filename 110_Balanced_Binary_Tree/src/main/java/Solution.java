/**
 * Definition for a binary tree node.
 */
class Solution
{
    public static void main(String[] args)
    {
        TreeNode treeNode = new TreeNode(2147483647);
        treeNode.left = new TreeNode(2147483647);
        treeNode.right = new TreeNode(2147483647);

        treeNode.left.right = new TreeNode(2147483647);
        treeNode.left.right.right = new TreeNode(2147483647);
        treeNode.right.right = new TreeNode(2147483647);
        treeNode.right.right.right = new TreeNode(2147483647);
        //        treeNode.right.right.right.right = new TreeNode(2147483647);
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(treeNode));
    }

    public boolean isBalanced(TreeNode root)
    {
        if(root == null)
            return true;
        int left = getHeight(root.left, 0);
        int right = getHeight(root.right, 0);
        return left != -1 && right != -1 && Math.abs(left - right) <= 1;
    }

    private int getHeight(TreeNode root, int h)
    {
        if (root == null)
            return h;
        int leftHeight = getHeight(root.left, h + 1);
        int rightHeight = getHeight(root.right, h + 1);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight);
    }

    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }
}