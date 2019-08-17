public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length <= 1)
            return profit;
        int minBuyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (minBuyPrice > prices[i])
                minBuyPrice = prices[i];
            int localProfit = prices[i] - minBuyPrice;
            if (localProfit > profit)
                profit = localProfit;
        }
        return profit;
    }
}
