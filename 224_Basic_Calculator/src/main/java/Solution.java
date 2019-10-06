import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("1 + 5 + 2 - 2"));
    }

    public static int calculate(String s) {

        Queue<Character> q = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(c!=' ') {
                q.offer(c);
            }
        }

        q.offer(' ');
        return helper(q);
    }


    private static int helper(Queue<Character> q) {
        int num = 0, prev = 0, sum = 0;
        char prevOp = '+';

        while (!q.isEmpty()) {
            char c = q.poll();
            String str = c==' ' ? "null" : "Not null";
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                num = helper(q);
            } else {
                switch (prevOp) {
                    case '+':
                        sum += prev;
                        prev = num;
                        break;

                    case '-':
                        sum += prev;
                        prev = -num;
                        break;

                    case '*':
                        prev *= num;
                        break;

                    case '/':
                        prev /= num;
                        break;
                }
                if (c == ')') break;
                prevOp = c;
                num = 0;
            }
        }

        return sum + prev;
    }
}