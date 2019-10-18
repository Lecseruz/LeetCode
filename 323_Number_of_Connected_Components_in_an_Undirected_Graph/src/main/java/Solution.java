public class Solution
{
    private int[] array;

    // opens the site (row, col) if it is not open already
    public int root(int i)
    {
        while (i != array[i])
        {
            array[i] = array[array[i]];
            i = array[i];
        }
        return i;
    }

    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        array[i] = j;
    }

    // test client (optional)
    public static void main(String[] args)
    {
        Solution quickUnionUf = new Solution();
        System.out.println(quickUnionUf.countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
    }

    public int countComponents(int n, int[][] edges)
    {
        this.array = new int[n * n];
        for (int i = 0; i < n; ++i)
        {
            this.array[i] = i;
        }
        for (int i = 0; i < edges.length; ++i)
        {
            union(edges[i][0], edges[i][1]);
        }
        int k = 0;
        for (int i = 0; i < n; ++i)
        {
            if(this.array[i] == i)
                ++k;
        }
        return k;
    }
}
