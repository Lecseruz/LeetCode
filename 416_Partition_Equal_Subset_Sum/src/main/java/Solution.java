public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[] {1, 5, 11, 9}));
    }

    public boolean canPartition(int[] nums)
    {
        int numsSum = 0;
        for (int num : nums)
        {
            numsSum += num;
        }
        if (numsSum % 2 != 0)
            return false;

        /* The extra spot is the 0-empty case! */
        boolean[] dp = new boolean[numsSum / 2 + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = dp.length - 1; j >= nums[i]; j--)
            {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[dp.length - 1];
    }
}
