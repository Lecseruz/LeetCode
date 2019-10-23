import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution
{

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(-2);
        node.right = new TreeNode(-3);
        node.left.left = new TreeNode(-4);
        node.left.right = new TreeNode(-5);
        node.right.left = new TreeNode(-6);
        node.right.right = new TreeNode(-7);
        System.out.println(solution.maxLevelSum(node));
    }

    public int maxLevelSum(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return 0;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<TreeNode> list2 = new ArrayList<>();
        int max = root.val;
        int maxLevel = 1;
        int level = 0;
        while (!list.isEmpty())
        {
            ++level;
            int newMax = 0;
            for (int i = 0; i < list.size(); ++i)
            {
                TreeNode node = list.get(i);
                if (node == null)
                    continue;
                newMax += node.val;
                list2.add(node.left);
                list2.add(node.right);
            }
            list.clear();
            list.addAll(list2);
            list2.clear();
            if(max < newMax){
                maxLevel = level;
                max = newMax;
            }
        }
        return maxLevel;
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