class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{0, 1, 2, 0, 3});
    }
    public void moveZeroes(int[] nums) {
        int sizeZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = i; j > 0 && nums[j - 1] == 0; --j) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
}