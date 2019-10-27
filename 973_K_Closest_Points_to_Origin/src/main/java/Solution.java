import java.util.Comparator;
import java.util.PriorityQueue;

class Solution
{
    public int[][] kClosest(int[][] points, int K)
    {
        PriorityQueue<Point> pq = new PriorityQueue<Point>((Comparator)(obj1, obj2) -> {
            Point p1 = (Point)obj1;
            Point p2 = (Point)obj2;
            if (p1.getDistance() > p2.getDistance())
            {
                return 1;
            }
            else if (p1.getDistance() < p2.getDistance())
            {
                return -1;
            }
            else
            {
                return 0;
            }
        });
        for (int i = 0; i < points.length; ++i)
        {
            pq.offer(new Point(points[i][0], points[i][1]));
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; ++i)
        {
            Point tmp = pq.poll();
            result[i][0] = tmp.x;
            result[i][1] = tmp.y;
        }

        return result;
    }
}

class Point
{
    int x;
    int y;
    int distance;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.distance = x * x + y * y;
    }

    public int getDistance()
    {
        return this.distance;
    }
}
