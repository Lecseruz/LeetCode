import java.util.Stack;

/**
 * Definition for a binary tree node.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recoverFromPreorder("1-2--3");
    }
    int strIndex = 0; // mark the current position of S
    int nextDep = 0; // global variable, represent the depth that is to visit next

    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        return dfs(S, 0);
    }

    private TreeNode dfs(String S, int curDep) {
        nextDep = 0;
        int val = getNextValue(S);
        TreeNode root = new TreeNode(val);

        // reach end of the string
        if (strIndex == S.length()) {
            return root;
        }
        while (S.charAt(strIndex) == '-') {
            strIndex++;
            nextDep++;
        }
        // left subtree
        if (nextDep > curDep) {
            root.left = dfs(S, nextDep);
        }
        // the depth of the next destination is smaller, apply backtracking
        if (nextDep <= curDep) {
            return root;
        }
        // find the target, append right subtree
        if (nextDep == curDep + 1) {
            root.right = dfs(S, nextDep);
        }

        return root;
    }

    private int getNextValue(String S) {
        int start = strIndex;
        while (strIndex < S.length() && S.charAt(strIndex) != '-') {
            strIndex++;
        }
        return Integer.parseInt(S.substring(start, strIndex));
    }
//    public TreeNode recoverFromPreorder(String S) {
//        if (S.length() == 0)
//            return null;
//        for (int i = 0; i < (S.length() - 1); i++) {
//            boolean b = Character.isDigit(S.charAt(i));
//            boolean b1 = Character.isDigit(S.charAt(i + 1));
//            if (b != b1) {
//                i++;
//                S = S.substring(0, i) + " " + S.substring(i, S.length());
//            }
//        }
//        String[] s = S.split(" ");
//        int curr = Integer.parseInt(s[0]);
//        TreeNode node = new TreeNode(curr);
//        TreeNode currNode = node;
//        int h = 1;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(currNode);
//        for (int i = 1; i < s.length; ++i) {
//            S = s[i];
//            while (h != S.length()) {
//                stack.pop();
//                --h;
//            }
//            curr = Integer.parseInt(s[++i]);
//            currNode = new TreeNode(curr);
//            if (stack.peek().left == null)
//            stack.peek().left = currNode;
//            else
//            stack.peek().right = currNode;
//            stack.push(currNode);
//            ++h;
//        }
//        return node;
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}