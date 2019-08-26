import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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
        Solution solution = new Solution();
        solution.averageOfLevels(treeNode);
    }
    public List<Double> averageOfLevels(TreeNode root)
    {
        List<Double> list = new ArrayList<>();
        List<List<Double>> listElemLists = new ArrayList<>();
        function(listElemLists, 0, root);
        listElemLists.forEach(integers -> {
            double sum = integers.stream().mapToDouble(Double::doubleValue).sum();
            list.add(sum / integers.size());
        });
        return list;
    }

    private void function(List<List<Double>> list, int h, TreeNode root)
    {
        if (list.size() <= h)
            list.add(new ArrayList<>());
        list.get(h).add((double)root.val);
        if (root.left != null)
            function(list, h + 1, root.left);
        if (root.right != null)
            function(list, h + 1, root.right);
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