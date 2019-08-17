class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(2, 3));
    }
    public int numWays(int n, int k) {
        if( n == 0)
            return 0;
        if (n == 1)
            return k;
        int same = k;
        int different = k * k - k;
        for (int i = 2; i < n; ++i) {
            int temp = different;
            different = same * (k - 1) + different * k - different;
            same = temp;
        }
        return same + different;
    }
}