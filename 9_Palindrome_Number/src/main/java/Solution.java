class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(123454321));
    }

    public boolean isPalindrome(int x) {
        StringBuilder builder = new StringBuilder();
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        while (x != 0) {
            builder.append(x % 10);
            x /= 10;
        }
        return builder.toString().equals(builder.reverse().toString());
    }
}