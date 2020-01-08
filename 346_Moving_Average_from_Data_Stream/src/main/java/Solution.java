import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

class MovingAverage {

    int size = 0;
    int sum = 0;
    private Deque<Integer> deque = new LinkedBlockingDeque<>();

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if(deque.size() == size && !deque.isEmpty())
            sum -= deque.pollLast();
        sum += val;
        deque.push(val);
        return (double) sum / deque.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */