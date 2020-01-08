import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(0));
    }

    public int countPrimes(int n) {
        if (n == 0 || n == 1)
            return 0;
        int k = 0;
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i < Math.sqrt(n); ++i) {
            int j = 2;
            while (i * j < n) {
                arr[i * j] = false;
                ++j;
            }
        }
        for (int i = 2; i < n; ++i) {
            if (arr[i])
                ++k;
        }
        return k;
    }
}