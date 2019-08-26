import java.util.Arrays;
import java.util.stream.Stream;

class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        Arrays.stream(solution.countBits(0)).forEach(System.out::println);
    }
    public int[] countBits(int num)
    {
        if(num == 0)
            return new int[]{0};
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        int n = 2;
        for (int i = 2; i <= num; ++i)
        {
            if (n * 2 == i)
                n *= 2;
            dp[i] = dp[i - n] + 1;
        }
        return dp;
    }
}