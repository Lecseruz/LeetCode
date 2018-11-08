class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (i = 0; i < bits.length - 1; ++i) {
            if (bits[i] == 1)
                ++i;
        }
        return !(i == bits.length);
    }
}