public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(-3);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.left.right.right = new TreeNode(1);

        System.out.println(solution.pathSum(treeNode, 8));
    }

    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int depth = findDepth(root);
        int[] pathArray = new int[depth];
        helper(root, sum, pathArray, 0, depth);
        return count;
    }

    public void helper(TreeNode root, int total, int[] nums, int level, int depth) {
        if(root == null) return;
        if(level >= depth) return;
        nums[level] = root.val;
        int sum = 0;
        for(int i = level; i>=0; i--) {
            sum += nums[i];
            if(sum == total)
                count++;
        }
        helper(root.left, total, nums, level + 1, depth);
        helper(root.right, total, nums, level + 1, depth);
    }

    public int findDepth(TreeNode root) {
        if(root == null) return 0;
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        return Math.max(left, right) + 1;
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
