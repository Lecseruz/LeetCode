public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(2));
    }

    private Long binomial(int n, int k)
    {
        Long res = 1L;
        k = k > (n - k) ? (n - k) : k;
        for (int i = 0; i < k; i++)
        {
            res *= n - i;
            res /= i + 1;
        }
        return res;
    }

    public int numTrees(int n)
    {
        return (int)(binomial(n << 1, n) / (n + 1));
    }
}