import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.isBipartite(new int[][] {
                {}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9},
                {2, 4, 5, 6, 7, 8}
        }));
    }

    public boolean isBipartite(int[][] graph)
    {
        int group[] = new int[graph.length];
        Arrays.fill(group, -1);
        for (int i = 0; i < graph.length; i++)
        {
            if (group[i] == -1 && !help(i, graph, group, 0))
                return false;
        }
        return true;
    }

    public boolean help(int index, int[][] graph, int group[], int color)
    {
        if (group[index] == color)
            return true;
        group[index] = color;
        for (int i = 0; i < graph[index].length; i++)
        {
            if (group[graph[index][i]] == color || !help(graph[index][i], graph, group, 1 - color))
                return false;
        }
        return true;
    }
    //    public boolean isBipartite(int[][] graph)
    //    {
    //        Map<Integer, Set<Integer>> map = new HashMap<>();
    //        Set<Integer> visited = new HashSet<>();
    //        Map<Integer, Integer> setMap = new HashMap<>();
    //        for (int i = 0; i < graph.length; ++i)
    //        {
    //            Integer[] what = Arrays.stream(graph[i]).boxed().toArray(Integer[]::new);
    //            map.put(i, convertArrayToSet(what));
    //        }
    //        for (int i = 0; i < graph.length; ++i)
    //        {
    //            if (!visited.contains(i))
    //            {
    //                ArrayDeque<Integer> queue = new ArrayDeque<>();
    //                queue.addFirst(i);
    //                setMap.put(i, 1);
    //                while (!queue.isEmpty())
    //                {
    //                    int value = queue.pollFirst();
    //                    visited.add(value);
    //                    Set<Integer> set = map.get(value);
    //                    for (Integer integer : set)
    //                    {
    //                        if (!visited.contains(integer))
    //                        {
    //                            queue.addLast(integer);
    //                            setMap.put(integer, setMap.get(value) == 1 ? 0 : 1);
    //                        }
    //                        else if (setMap.get(value).equals(setMap.get(integer)))
    //                        {
    //                            return false;
    //                        }
    //                    }
    //                }
    //            }
    //        }
    //        return true;
    //    }

    // Generic function to convert array to set
    public static Set<Integer> convertArrayToSet(Integer[] array)
    {
        // create a set from the Array
        return Arrays.stream(array).collect(Collectors.toSet());
    }
}