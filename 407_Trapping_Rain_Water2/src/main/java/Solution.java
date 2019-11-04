import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}});
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m <= 2) return 0;
        int n = heightMap[0].length;
        if (n <= 2) return 0;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int j = 0; j < n; ++j) {
            visited[0][j] = true;
            q.add(new int[]{heightMap[0][j], 0, j});
            visited[m - 1][j] = true;
            q.add(new int[]{heightMap[m - 1][j], m - 1, j});
        }
        for (int i = 1; i < m - 1; ++i) {
            visited[i][0] = true;
            q.add(new int[]{heightMap[i][0], i, 0});
            visited[i][n - 1] = true;
            q.add(new int[]{heightMap[i][n - 1], i, n - 1});
        }
        int sum = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int count = (m - 2) * (n - 2);
        while (count > 0) {
            int[] c = q.poll();
            for (int[] d : dir) {
                int x = c[1] + d[0];
                int y = c[2] + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    --count;
                    sum += Math.max(0, c[0] - heightMap[x][y]);
                    q.add(new int[]{Math.max(c[0], heightMap[x][y]), x, y});
                }
            }
        }

        return sum;
    }
}