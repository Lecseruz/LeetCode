class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.numberOfArithmeticSlices(new int[] {1, 2, 3, 4, 5, 6}));
    }

    public int numberOfArithmeticSlices(int[] A)
    {
        if (A.length < 3)
            return 0;
        int count = 0;
        for (int i = 0; i <= A.length - 3; ++i)
        {
            int j = 2;
            while (i + j < A.length && isArithmetic(A, i + j))
            {
                ++j;
                ++count;
            }
        }
        return count;
    }

    private boolean isArithmetic(int[] a, int j)
    {
        return a[j] - a[j - 1] == a[j - 1] - a[j - 2];
    }
}