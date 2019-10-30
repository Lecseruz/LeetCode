import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution
{
    //    public static void main(String[] args)
    //    {
    //        Solution solution = new Solution();
    //        System.out.println(solution.minMeetingRooms(new int[][] {
    //                {9, 10}, {4, 9}, {4, 17}
    //        }));
    //    }
    public int minMeetingRooms(int[][] intervals)
    {

        if (intervals.length == 0)
        {
            return 0;
        }
        PriorityQueue<Integer> rooms = new PriorityQueue<>((p, q) -> p - q);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        rooms.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++)
        {
            int endTime = rooms.peek();
            if (endTime <= intervals[i][0])
            {
                rooms.poll();
            }
            rooms.add(intervals[i][1]);
        }

        return rooms.size();
    }

//    public int minMeetingRooms(int[][] intervals)
//    {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int[] arr : intervals)
//        {
//            map.computeIfPresent(arr[0], (key, value) -> ++value);
//            map.computeIfPresent(arr[1], (key, value) -> --value);
//            map.putIfAbsent(arr[0], 1);
//            map.putIfAbsent(arr[1], -1);
//        }
//        int max = 0;
//        int count = 0;
//        Set<Integer> array = Stream.of(intervals).flatMapToInt(IntStream::of).sorted().boxed().collect(
//                Collectors.toCollection(LinkedHashSet::new));
//        for (int val : array)
//        {
//            count += map.get(val);
//            max = Math.max(count, max);
//        }
//        return max;
//    }
}