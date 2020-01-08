import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(2));
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int value = n;
            int sum = 0;
            while (value != 0) {
                int sum1 = value % 10;
                sum += sum1 * sum1;
                value /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}