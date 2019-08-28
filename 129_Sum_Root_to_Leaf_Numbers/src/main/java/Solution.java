import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(9);
        node.right = new TreeNode(0);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(1);
//        node.right.left = new TreeNode(6);
//        node.right.right = new TreeNode(7);
        System.out.println(solution.sumNumbers(node));
    }

    public int sumNumbers(TreeNode root)
    {
        List<String> list = new ArrayList<>();
        fillList(root, "", list);
        int sum = 0;
        for (String value : list)
        {
            sum += Integer.valueOf(value);
        }
        return sum;
    }

    public void fillList(TreeNode root, String path, List<String> list)
    {
        if (root == null)
            return;
        String path1 = path + root.val;
        if (root.left == null && root.right == null)
            list.add(path1);
        fillList(root.left, path1, list);
        fillList(root.right, path1, list);
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
