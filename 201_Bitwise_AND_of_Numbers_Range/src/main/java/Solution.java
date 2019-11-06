class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rangeBitwiseAnd(
                2147483646,
                2147483647);
    }

    public int rangeBitwiseAnd(int m, int n) {
        int sum = m;
        while (m <= n) {
            sum &= m;
            if (sum == 0)
                return 0;
            ++m;
        }
        return sum;
    }
}