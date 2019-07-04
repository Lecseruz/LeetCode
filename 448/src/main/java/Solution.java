import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findDisappearedNumbers(new int[]{1, 1});
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }

        return ret;
    }
}
