import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }
    public String removeDuplicates(String S)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); ++i)
        {
            if (!stack.isEmpty() && stack.peek() == S.charAt(i))
            {
                stack.pop();
            }
            else
            {
                stack.push(S.charAt(i));
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}