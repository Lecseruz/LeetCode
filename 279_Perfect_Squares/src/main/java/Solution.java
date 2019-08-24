import java.util.Arrays;

class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(20));
    }

    public int numSquares(int n)
    {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        int i = 0;
        while (++i * i <= n)
        {
            for (int j = i * i; j < memo.length; j++)
            {
                memo[j] = Math.min(memo[j], memo[j - (i * i)] + 1);
            }
        }
        return memo[n];
    }
}