public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(1);
//        treeNode.right = new TreeNode(3);
//        treeNode.left.left = new TreeNode(11);
//        treeNode.right.left = new TreeNode(13);
//        treeNode.right.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.right = new TreeNode(3);
//        treeNode.right.right.right = new TreeNode(10);

        System.out.println(solution.rob(treeNode));
    }

    public int rob(TreeNode root)
    {
        if (root == null)
            return 0;
        compute(root);
        return root.val;
    }

    public int compute(TreeNode root)
    {
        if (root == null)
            return 0;
        int val = 0;
        if (root.left != null)
        {
            root.val += compute(root.left);
            val += root.left.val;
        }
        if (root.right != null)
        {
            root.val += compute(root.right);
            val += root.right.val;
        }
        if(root.val < val)
            root.val = val;
        return val;
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
