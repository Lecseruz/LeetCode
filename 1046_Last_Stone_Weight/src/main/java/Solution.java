import java.util.PriorityQueue;

class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(new int[] {2, 4, 8, 2, 1, 1}));
    }

    public int lastStoneWeight(int[] stones)
    {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->(b-a));//maxheap
        for (int stone : stones)
        {
            priorityQueue.add(stone);
        }

        while (priorityQueue.size() > 1)
        {
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            int c = Math.abs(x - y);
            if (c != 0)
                priorityQueue.add(c);
        }
        return priorityQueue.size() == 0 ? 0 : priorityQueue.poll();
    }
}