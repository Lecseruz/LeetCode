import java.util.Arrays;

class Solution
{
    final int N = 26;

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.alienOrder(new String[] {
                "wrt", "wrf", "rw", "rsr", "rst", "rr", "rt"
        }));

    }

    public String alienOrder(String[] words)
    {
        if (words == null || words.length == 0)
            return "";

        int[] visited = new int[N];
        Arrays.fill(visited, -1);

        //graph[i][j] = char[i-'a'] comes before  char[j-'a'] 
        int[][] graph = new int[N][N];

        build_graph(words, graph, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < visited.length; i++)
        {
            if (visited[i] == 0)
            {
                if (!dfs(i, graph, visited, sb))
                {
                    return "";
                }
            }
        }
        return sb.reverse().toString();
    }

    boolean dfs(int i, int[][] graph, int[] visited, StringBuilder sb)
    {
        if (visited[i] == 1)
        {
            return false;   //cycle detection
        }
        if (visited[i] == 2)
        {
            return true;    //this char has already been added, skip 
        }

        visited[i] = 1;     //currently visiting
        for (int j = 0; j < N; j++)
        {
            if (graph[i][j] == 1)
            {
                if (!dfs(j, graph, visited, sb))
                    return false;
            }
        }
        visited[i] = 2;         //just finished, add to dictionary 
        char c = (char)(i + 'a');
        sb.append(c);
        return true;
    }

    void build_graph(String[] words, int[][] graph, int[] visited)
    {
        char[] cs_last = words[words.length - 1].toCharArray();
        for (char ch : cs_last)
        {
            if (visited[ch - 'a'] == -1)
                visited[ch - 'a'] = 0;
        }

        for (int i = 0; i < words.length - 1; i++)
        {
            char[] cs = words[i].toCharArray();
            for (char c : cs)
            {
                visited[c - 'a'] = 0;     //char c exists in words list
            }

            String w1 = words[i];
            String w2 = words[i + 1];
            int maxlen = Math.min(w1.length(), w2.length());
            for (int j = 0; j < maxlen; j++)
            {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2)
                {
                    graph[c1 - 'a'][c2 - 'a'] = 1;
                    break;
                }
            }
        }
    }
}