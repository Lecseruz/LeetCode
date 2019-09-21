import java.util.Stack;

class Solution {

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

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                // update the state of this row's histogram using the last row's histogram
                // by keeping track of the number of consecutive ones

                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            // update maxarea with the maximum area from this row's histogram
            maxarea = Math.max(maxarea, largestRectangleArea(dp));
        }
        return maxarea;
    }

    //Dyncamic Programming
//    public int maximalRectangle(char[][] matrix) {
//        if (matrix.length == 0) return 0;
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int[] left = new int[n]; // initialize left as the leftmost boundary possible
//        int[] right = new int[n];
//        int[] height = new int[n];
//
//        Arrays.fill(right, n); // initialize right as the rightmost boundary possible
//
//        int maxarea = 0;
//        for (int i = 0; i < m; i++) {
//            int cur_left = 0, cur_right = n;
//            // update height
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == '1') height[j]++;
//                else height[j] = 0;
//            }
//            // update left
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
//                else {
//                    left[j] = 0;
//                    cur_left = j + 1;
//                }
//            }
//            // update right
//            for (int j = n - 1; j >= 0; j--) {
//                if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
//                else {
//                    right[j] = n;
//                    cur_right = j;
//                }
//            }
//            // update area
//            for (int j = 0; j < n; j++) {
//                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
//            }
//        }
//        return maxarea;
//    }
}