import java.util.Stack;

class MinStack
{
    Stack<Integer> s2 = new Stack<Integer>();
    Stack<Integer> s1 = new Stack<Integer>();

    public void push(int value)
    {
        if (value <= getMin())
        {
            s2.push(value);
        }
        s1.push(value);
    }

    public Integer pop()
    {
        int value = s1.pop();
        if (value == getMin())
        {
            s2.pop();
        }
        return value;
    }

    public int getMin()
    {
        if (s2.isEmpty())
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            return s2.peek();
        }
    }

    public int top()
    {
        return s1.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */