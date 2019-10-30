class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.minSwapsCouples(new int[] {0, 4, 5, 3, 2, 6, 1, 7}));
    }

    public int minSwapsCouples(int[] row)
    {
        int N = row.length / 2;
        //couples[x] = {i, j} means that
        //couple #x is at couches i and j (1 indexed)
        int[][] couples = new int[N][2];

        for (int i = 0; i < row.length; ++i)
        {
            add(couples[row[i] / 2], i / 2 + 1);
        }

        //adj[x] = {i, j} means that
        //x-th couch connected to couches i, j (all 1 indexed) by couples
        int[][] adj = new int[N + 1][2];
        for (int[] couple : couples)
        {
            add(adj[couple[0]], couple[1]);
            add(adj[couple[1]], couple[0]);
        }

        // The answer will be N minus the number of cycles in adj.
        int ans = N;
        // For each couch (1 indexed)
        for (int r = 1; r <= N; ++r)
        {
            // If this couch has no people needing to be paired, continue
            if (adj[r][0] == 0 && adj[r][1] == 0)
                continue;

            // Otherwise, there is a cycle starting at couch r.
            // We will use two pointers x, y with y faster than x by one turn.
            ans--;
            int x = r, y = pop(adj[r]);
            // When y reaches the start 'r', we've reached the end of the cycle.
            while (y != r)
            {
                // We are at some couch with edges going to 'x' and 'new'.
                // We remove the previous edge, since we came from x.
                rem(adj[y], x);

                // We update x, y appropriately: y becomes new and x becomes y.
                x = y;
                y = pop(adj[y]);
            }
        }
        return ans;
    }

    // Replace the next zero element with x.
    public void add(int[] pair, int x)
    {
        pair[pair[0] == 0 ? 0 : 1] = x;
    }

    // Remove x from pair, replacing it with zero.
    public void rem(int[] pair, int x)
    {
        pair[pair[0] == x ? 0 : 1] = 0;
    }

    // Remove the next non-zero element from pair, replacing it with zero.
    public int pop(int[] pair)
    {
        int x = pair[0];
        if (x != 0)
        {
            pair[0] = 0;
        }
        else
        {
            x = pair[1];
            pair[1] = 0;
        }
        return x;
    }
    //    public int minSwapsCouples(int[] row)
    //    {
    //        int count = 0;
    //        for (int i = 0; i < row.length; ++i)
    //        {
    //            if (i % 2 != 0 && !isCouple(row[i - 1], row[i]))
    //            {
    //                for (int j = 0; j < row.length; ++j)
    //                {
    //                    if (row[i - 1] % 2 == 0 && row[j] - row[i - 1] == 1)
    //                    {
    //                        count++;
    //                        swap(row, i, j);
    //                        break;
    //                    }
    //                    else if (row[i - 1] % 2 == 1 && row[i - 1] - row[j] == 1)
    //                    {
    //                        count++;
    //                        swap(row, i, j);
    //                        break;
    //                    }
    //                }
    //            }
    //        }
    //        return count;
    //    }

    //    public int minSwapsCouples(int[] row)
    //    {
    //        int ans = 0;
    //        for (int i = 0; i < row.length; i += 2)
    //        {
    //            int x = row[i];
    //            if (row[i + 1] == (x ^ 1))
    //                continue;
    //            ans++;
    //            for (int j = i + 1; j < row.length; ++j)
    //            {
    //                if (row[j] == (x ^ 1))
    //                {
    //                    row[j] = row[i + 1];
    //                    row[i + 1] = x ^ 1;
    //                    break;
    //                }
    //            }
    //        }
    //        return ans;
    //    }

    private boolean isCouple(int i, int i1)
    {
        int max = Math.max(i, i1);
        int min = Math.min(i, i1);
        return max % 2 == 1 && max - min == 1;
    }

    private void swap(int[] arr, int first, int secons)
    {
        int temp = arr[first];
        arr[first] = arr[secons];
        arr[secons] = temp;
    }
}