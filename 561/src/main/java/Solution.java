import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.arrayPairSum(new int[]{1, 3, 4, 2, 4, 2}));
    }
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ;i += 2){
            sum += nums[i];
        }
        return sum;
    }
}