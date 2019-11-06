public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(25));

    }
    public int reverseBits(int n) {
        StringBuilder resultBits = new StringBuilder();
        int val = 0;
        while (n > 0) {
            val = n & 1;
            resultBits.append(val);
            n >>= 1;
        }
        return (int) Long.parseLong(resultBits.toString(), 2);
    }
}