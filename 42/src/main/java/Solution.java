import java.util.Stack;

import static java.lang.Math.max;
import static java.lang.Math.min;

class Solution {
    //    public int trap(int[] height) {
//        int ans = 0, current = 0;
//        Stack<Integer> st = new Stack<>();
//        while (current < height.length) {
//            while (!st.empty() && height[current] > height[st.peek()]) {
//                int top = st.peek();
//                st.pop();
//                if (st.empty())
//                    break;
//                int distance = current - st.peek() - 1;
//                int bounded_height = min(height[current], height[st.peek()]) - height[top];
//                ans += distance * bounded_height;
//            }
//            st.push(current++);
//        }
//        return ans;
//    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    int trap(int[] height) {
        if (height.length <= 1)
            return 0;
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }
}