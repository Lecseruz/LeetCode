import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[] {2, 3, 6, 10, 1, 4, 5, 8}));
    }

    public int lengthOfLIS(int[] nums)
    {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums)
        {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0)
            {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len)
            {
                len++;
            }
        }
        return len;
    }
}