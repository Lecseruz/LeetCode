import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{}));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                int rectangle;
                if (stack.isEmpty())
                    rectangle = heights[index] * (i);
                else
                    rectangle = heights[index] * (i - stack.peek() - 1);
                max = Math.max(rectangle, max);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int rectangle;
            if (stack.isEmpty())
                rectangle = heights[index] * (heights.length);
            else
                rectangle = heights[index] * (heights.length - stack.peek() - 1);
            max = Math.max(rectangle, max);
        }
        return max;
    }
}