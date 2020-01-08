class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(1534236469));
    }

    public int reverse(int x) {
        if (x == 0)
            return 0;
        int value = Math.abs(x);
        int flag = x < 0 ? -1 : 1;
        StringBuilder builder = new StringBuilder();
        while (value != 0) {
            builder.append(value % 10);
            value /= 10;
        }
        return (int) (Long.parseLong(builder.toString()) * flag);
    }
}