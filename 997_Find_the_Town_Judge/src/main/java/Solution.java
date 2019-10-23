import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.findJudge(4, new int[][] {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }

    public int findJudge(int N, int[][] trust)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] array = new int[N + 1];
        for (int i = 0; i <= N; ++i)
        {
            array[i] = i;
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < trust.length; ++i)
        {
            array[trust[i][0]] = trust[i][1];
            List<Integer> list = map.get(trust[i][1]);
            list.add(trust[i][0]);
        }
        int human = -1;
        for (int i = 1; i <= N; ++i)
        {
            if (array[i] == i)
            {
                List<Integer> list = map.get(i);
                return list.size() == N - 1 ? i : human;
            }
        }
        return human;
    }
}