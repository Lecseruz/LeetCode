import java.util.PriorityQueue;

class KthLargest
{
    private PriorityQueue<Integer> pqMax;
    private PriorityQueue<Integer> pqMin = new PriorityQueue<>();

    public KthLargest(int k, int[] nums)
    {
        pqMax = new PriorityQueue<>((a, b) -> (b - a));//maxheap
        for (Integer num : nums)
        {
            pqMax.add(num);
        }
        for (int i = 0; i < k - 1; ++i)
        {
            pqMin.add(pqMax.poll());
        }
    }

    public int add(int val)
    {
        if (pqMax.size() != 0 && pqMax.peek() >= val)
            pqMax.add(val);
        else
        {
            pqMin.add(val);
            pqMax.add(pqMin.poll());
        }
//        System.out.println(pqMax.peek());
        return pqMax.peek();
    }

//    public static void main(String[] args)
    ////    {
    ////        int k = 1;
    ////        int[] arr = {};
    ////        KthLargest kthLargest = new KthLargest(k, arr);
    ////        kthLargest.add(3);   // returns 4
    ////        kthLargest.add(5);   // returns 5
    ////        kthLargest.add(10);  // returns 5
    ////        kthLargest.add(9);   // returns 8
    ////        kthLargest.add(4);   // returns 8
    ////    }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest obj = new KthLargest(k, nums); int param_1
 * = obj.add(val);
 */