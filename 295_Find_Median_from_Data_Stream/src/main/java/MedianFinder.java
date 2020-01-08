import java.util.PriorityQueue;

class MedianFinder {
    /** initialize your data structure here. */
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(1);
        medianFinder.findMedian();
        medianFinder.addNum(3);
        medianFinder.findMedian();
    }
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        if(minHeap.size() + 1 <maxHeap.size()) minHeap.add(maxHeap.poll());
        else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
}