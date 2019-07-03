import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.plusOne(new int[]{0});
    }

    public int[] plusOne(int[] digits) {
        int k = 1;
        int i = digits.length - 1;
        while (k == 1 && i >= 0) {
            int value = digits[i] + 1;
            k = value / 10;
            digits[i] = value % 10;
            --i;
        }
        if (i == -1 && k == 1) {
            int[] array = new int[digits.length + 1];
            array[0] = 1;
            for (i = 1; i < array.length; ++i) {
                array[i] = digits[i - 1];
            }
            return array;
        }
        return digits;
    }
}
