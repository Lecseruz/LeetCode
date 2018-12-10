import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("D"));
    }
    public int romanToInt(String s)
    {
        int result = 0;
        LinkedList<MetaElement> queue = new LinkedList<>();
        for (Character el : s.toCharArray())
        {
            switch (el)
            {
            case 'I':
            {
                queue.add(new MetaElement(1, 1));
                break;
            }
            case 'V':
            {
                queue.add(new MetaElement(2, 5));
                break;
            }
            case 'X':
            {
                queue.add(new MetaElement(3, 10));
                break;
            }
            case 'L':
            {
                queue.add(new MetaElement(4, 50));
                break;
            }
            case 'C':
            {
                queue.add(new MetaElement(5, 100));
                break;
            }
            case 'D':
            {
                queue.add(new MetaElement(6, 500));
                break;
            }
            case 'M':
            {
                queue.add(new MetaElement(7, 1000));
                break;
            }
            default:
            {
                break;
            }
            }
        }
        MetaElement pre = queue.pollFirst();
        MetaElement last = new MetaElement();
        while (!queue.isEmpty())
        {
            MetaElement metaElement = queue.pop();
            if (pre.priority >= metaElement.priority)
            {
                result += pre.value;
                last = metaElement;
                pre = metaElement;
            }
            else
            {
                result += metaElement.value - pre.value;
                if(!queue.isEmpty()){
                    pre = queue.pollFirst();
                    last = pre;
                }else {
                    last = null;
                }
            }
        }
        if(last != null){
            result += pre.value;
        }
        return result;
    }

    public static class MetaElement
    {
        int priority;
        int value;

        public MetaElement()
        {
        }

        public MetaElement(int i, int el)
        {
            this.priority = i;
            this.value = el;
        }
    }
}