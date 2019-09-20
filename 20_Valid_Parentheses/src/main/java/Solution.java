import java.util.Stack;

class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i)
        {
            char value = s.charAt(i);
            switch (value)
            {
            case '{':
            {
                stack.push(value);
                break;
            }
            case '}':
            {
                if (stack.isEmpty())
                    return false;
                char el = stack.pop();
                if (el != '{')
                    return false;
                break;
            }
            case '[':
            {
                stack.push(value);
                break;
            }
            case ']':
            {
                if (stack.isEmpty())
                    return false;
                char el = stack.pop();
                if (el != '[')
                    return false;
                break;
            }
            case '(':
            {
                stack.push(value);
                break;
            }
            case ')':
            {
                if (stack.isEmpty())
                    return false;
                char el = stack.pop();
                if (el != '(')
                    return false;
                break;
            }
            default:
                break;
            }
        }
        return true;
    }
}