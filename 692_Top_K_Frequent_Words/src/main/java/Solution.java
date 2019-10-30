import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution
{
//    public static void main(String[] args)
//    {
//        Solution solution = new Solution();
//        solution.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2);
//    }

    public List<Integer> topKFrequent(int[] nums, int k)
    {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Comparator)(obj1, obj2) -> {
            Pair p1 = (Pair)obj1;
            Pair p2 = (Pair)obj2;
            return Integer.compare(p2.count, p1.count);
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
        {
            map.computeIfPresent(nums[i], (key, value) -> ++value);
            map.putIfAbsent(nums[i], 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            Pair tmp = new Pair(entry.getKey(), entry.getValue());
            pq.add(tmp);
        }
        for (int i = 0; i < k; ++i)
        {
            list.add(pq.poll().value);
        }
        return list;
    }

    class Pair
    {
        int value;
        int count;

        public Pair(int value, int count)
        {
            this.value = value;
            this.count = count;
        }
    }
}
