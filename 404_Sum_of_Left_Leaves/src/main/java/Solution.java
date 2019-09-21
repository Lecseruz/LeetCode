public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
//        treeNode.right.right = new TreeNode(7);
        //        treeNode.left.right = new TreeNode(2);
        //        treeNode.left.right.left = new TreeNode(7);
//        treeNode.right.right.left = new TreeNode(1);

        System.out.println(solution.sumOfLeftLeaves(treeNode));
    }

    public int sumOfLeftLeaves(TreeNode root)
    {
        if (root == null)
            return 0;
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean flag)
    {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null && flag)
            return root.val;
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
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
