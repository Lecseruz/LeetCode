import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(-2);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(11);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.right.right = new TreeNode(1);

        System.out.println(solution.findSecondMinimumValue(treeNode));
    }

    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        Set<Integer> set = new HashSet<>();
        fill(root, set);
        if(set.size() < 2)
            return -1;
        List<Integer> list = new ArrayList<>(set);
        list.sort(Integer::compareTo);
        return list.get(1);
    }

    public void fill(TreeNode root, Set<Integer> set) {
        if (root == null)
            return;
        set.add(root.val);
        fill(root.left, set);
        fill(root.right, set);
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
