import java.util.Stack;

class MyQueue
{
    private Stack<Integer> stackNewest = new Stack<>();
    private Stack<Integer> stackOldest = new Stack<>();

    public static void main(String[] args)
    {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.peek();
        myQueue.pop();
        System.out.println(myQueue.empty());
    }

    public void push(int value)
    {
        stackNewest.push(value);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop()
    {
        shiftStacks(); // Ensure stackOldest has the current elements
        return stackOldest.pop(); // pop the oldest item.
    }

    private void shiftStacks()
    {
        if (stackOldest.isEmpty())
        {
            while (!stackNewest.isEmpty())
            {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    /** Get the front element. */
    public int peek()
    {
        shiftStacks(); // Ensure stackOldest has the current elements
        return stackOldest.peek(); // retrieve the oldest item.
    }

    /** Returns whether the queue is empty. */
    public boolean empty()
    {
        return stackNewest.isEmpty() && stackOldest.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue(); obj.push(x); int param_2 =
 * obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */