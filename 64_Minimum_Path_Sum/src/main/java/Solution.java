import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (i > 0)
                    left = grid[i - 1][j];
                if (j > 0)
                    right = grid[i][j - 1];
                if (i != 0 || j != 0)
                    grid[i][j] += Math.min(left, right);
            }
        }
        return grid[m - 1][n - 1];
    }
}