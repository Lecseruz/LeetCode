import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution
{

    private int V;
    private List<List<Integer>> adj;

    // This function is a variation of DFSUytil() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)
    {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c : children)
        {
            if (isCyclicUtil(c, visited, recStack))
                return true;
        }

        recStack[i] = false;

        return false;
    }

    private void addEdge(int source, int dest)
    {
        adj.get(source).add(dest);
    }

    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclic()
    {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
        {
            if (isCyclicUtil(i, visited, recStack))
                return true;
        }

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        this.V = numCourses;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
        {
            adj.add(new LinkedList<>());
        }
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; ++i)
        {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; ++i)
        {
            addEdge(prerequisites[i][0], prerequisites[i][1]);
        }
        return isCyclic();
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.canFinish(6, new int[][] {{0, 1}, {0, 4}, {1, 2}, {1, 3}, {4, 3}, {4, 5}}));
    }
}