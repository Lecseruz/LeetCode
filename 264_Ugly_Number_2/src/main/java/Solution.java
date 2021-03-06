import java.util.TreeSet;

public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(1407));
    }

    public int nthUglyNumber(int n)
    {
        if (n < 0) {
            return -1;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            if (ugly[i] == ugly[i2] * 2) {
                i2++;
            }
            if (ugly[i] == ugly[i3] * 3) {
                i3++;
            }
            if (ugly[i] == ugly[i5] * 5) {
                i5++;
            }
        }
        return ugly[n-1];
    }
}
