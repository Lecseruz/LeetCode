import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxProfit(2, new int[]{2, 1, 2, 0, 1}));
        System.out.println(solution.maxProfit(2, new int[]{2, 4, 1}));
//        System.out.println(solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int k, int[] prices) {
        int lastn = 0, n = 0, lasty, y = Integer.MIN_VALUE;
        int profit = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            int tempn = n;
            n = Math.max(y + prices[i], tempn);
            if (n < 0)
                n = 0;
            lastn = tempn;
            lasty = y;
            y = Math.max(y, lastn - prices[i]);
            if (y > 0 && y - lasty > 0)
                list.add(profit);
            if (y == lasty)
                profit = n - lastn;
        }
        lastn = n;
        lasty = y;
        y = Math.max(y, lastn);
        if (y > 0 && y - lasty > 0)
            list.add(lasty > 0 ? profit : y);
        list.sort(Integer::compareTo);
        int sum = 0;
        for (int i = list.size() - 1; list.size() - i - 1 != k; --i)
            sum += list.get(i);
        return sum;
    }
}