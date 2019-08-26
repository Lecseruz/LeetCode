class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(10));
    }

    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int product = 1;
        while (n != 0) {
            if (n % 3 == 0 || n > 4) {
                product *= 3;
                n -= 3;
            } else {
                product *= 2;
                n -= 2;
            }
        }
        return product;
    }
}