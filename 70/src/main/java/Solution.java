public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
    }
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        if (n == 2)
            return b;
        if(n == 1)
            return a;
        int next = 0;
        for (int i = 3; i <= n; ++i) {
            next = a + b;
            a = b;
            b = next;
        }
        return next;
    }
}
