import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Matcher;

/*
// Definition for an Interval.

*/
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(6, 7));
        List<Interval> list3 = new ArrayList<>();
        list.add(new Interval(2, 4));
        List<Interval> list2 = new ArrayList<>();
        list.add(new Interval(2, 5));
        list.add(new Interval(9, 12));
        List<List<Interval>> lists = new ArrayList<>();
        lists.add(list);
        lists.add(list2);
        lists.add(list3);
        solution.employeeFreeTime(lists);
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start)
                    return Integer.compare(o1.start, o2.start);
                else
                    return Integer.compare(o2.end, o1.end);
            }
        });
        for (List<Interval> intervals : schedule) {
            for (Interval interval : intervals) {
                pq.add(interval);
            }
        }
        int start = -1;
        List<Interval> intervals = new ArrayList<>();
        while (!pq.isEmpty()) {
            Interval interval = pq.poll();
            if (start != -1 && start < interval.start) {
                intervals.add(new Interval(start, interval.start));
                start = interval.end;
            } else
                start = Math.max(start, interval.end);
        }
        return intervals;
    }

    public static class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    ;
}