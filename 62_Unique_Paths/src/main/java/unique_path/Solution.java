package unique_path;

import java.util.Arrays;

class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n)
    {
        if (m == 0 || n == 0)
            return 0;
        int[][] array = new int[m][n];
        for (int i = 0; i < m; ++i)
        {
            Arrays.fill(array[i], 1);
        }
        for (int i = 1; i < m; ++i)
        {
            for (int j = 1; j < n; ++j)
            {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m - 1][n - 1];
    }
}