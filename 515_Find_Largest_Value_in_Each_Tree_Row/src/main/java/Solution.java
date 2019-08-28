import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.println(solution.largestValues(node));
    }

    // BFS
    public List<Integer> largestValues(TreeNode root)
    {
        if (root == null)
            return new ArrayList<>();
        List<Integer> listMax = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<TreeNode> list2 = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while (!list.isEmpty())
        {
            for (int i = 0; i < list.size(); ++i)
            {
                TreeNode node = list.get(i);
                if (node.val > max)
                    max = node.val;
                if (node.left != null)
                    list2.add(node.left);
                if (node.right != null)
                    list2.add(node.right);
            }
            listMax.add(max);
            max = Integer.MIN_VALUE;
            list.clear();
            list.addAll(list2);
            list2.clear();
        }
        return listMax;
    }

    public static class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode()
        {
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next)
        {
            val = _val;
            left = _left;
            right = _right;
        }

        public TreeNode(int val)
        {
            this.val = val;
        }
    }
}
