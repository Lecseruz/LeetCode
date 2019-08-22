package unique_path.two;

import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] array = new int[][] {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(array));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        if (obstacleGrid.length == 0)
            return 0;
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1)
            return obstacleGrid[0][0] == 1 ? 0 : 1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] array = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean flag = false;
        for (int i = 0; i < m; ++i)
        {
            Arrays.fill(array[i], 1);
            if (obstacleGrid[i][0] == 1 || flag)
            {
                array[i][0] = 0;
                flag = true;
            }
        }
        flag = false;
        for (int i = 0; i < n; ++i)
        {
            if (obstacleGrid[0][i] == 1 || flag)
            {
                flag = true;
                array[0][i] = 0;
            }
        }
        for (int i = 1; i < m; ++i)
        {
            for (int j = 1; j < n; ++j)
            {
                if (obstacleGrid[i][j] != 1)
                {
                    array[i][j] = array[i - 1][j] + array[i][j - 1];
                }
                else
                {
                    array[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1 ? 0 : array[m - 1][n - 1];
    }
}
