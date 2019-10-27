import java.util.Arrays;

class Solution {
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1);
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dist = new int[2][n];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dist[0], INF);
        Arrays.fill(dist[1], INF);
        dist[0][src] = dist[1][src] = 0;

        for (int i = 0; i <= K; ++i)
            for (int[] edge: flights)
                dist[i&1][edge[1]] = Math.min(dist[i&1][edge[1]], dist[~i&1][edge[0]] + edge[2]);

        return dist[K&1][dst] < INF ? dist[K&1][dst] : -1;
    }
}