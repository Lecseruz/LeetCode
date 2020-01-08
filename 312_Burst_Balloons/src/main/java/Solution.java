import java.util.EnumMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
    }

    public int maxCoins(int[] nums) {

        // reframe the problem
        int n = nums.length + 2;
        int[] new_nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            new_nums[i + 1] = nums[i];
        }

        new_nums[0] = new_nums[n - 1] = 1;

        // cache the results of dp
        int[][] memo = new int[n][n];

        return dp(memo, new_nums, 0, n - 1);
    }

    private int dp(int[][] memo, int[] new_nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i) {
            ans = Math.max(ans, new_nums[left] * new_nums[i] * new_nums[right] + dp(memo, new_nums, left, i) +
                    dp(memo, new_nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
}