class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }

//        public int longestValidParentheses(String s) {
//            int maxans = 0;
//            int dp[] = new int[s.length()];
//            for (int i = 1; i < s.length(); i++) {
//                if (s.charAt(i) == ')') {
//                    if (s.charAt(i - 1) == '(') {
//                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
//                    }
//                    maxans = Math.max(maxans, dp[i]);
//                }
//            }
//            return maxans;
//        }

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        if (s.length() == 0)
            return 0;
        int max = 1;
        for (int i = 1; i < s.length(); ++i) {
            max = Math.max(max, dp[i]);
        }
        return max == 1 ? 0 : max;
    }
}