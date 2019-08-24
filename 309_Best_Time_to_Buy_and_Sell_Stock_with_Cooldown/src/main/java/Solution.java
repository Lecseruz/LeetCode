public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] {1, 2, 3, 4, 9, 10, 8}));
    }

    public int maxProfit(int[] prices)
    {
        int lastn = 0, n = 0, y = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++)
        {
            int tempn = n;
            n = Math.max(y + prices[i], tempn);
            if (n < 0)
                n = 0;
            y = Math.max(y, lastn - prices[i]);
            lastn = tempn;
        }
        return n;
        //        if(prices == null || prices.length < 2){
        //            return 0;
        //        }
        //        int len = prices.length;
        //        int[] sell = new int[len]; //sell[i] means must sell at day i
        //        int[] cooldown = new int[len]; //cooldown[i] means day i is cooldown day
        //        sell[1] = prices[1] - prices[0];
        //        for(int i = 2; i < prices.length; ++i){
        //            cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
        //            sell[i] = prices[i] - prices[i - 1] + Math.max(sell[i - 1], cooldown[i - 2]);
        //        }
        //        return Math.max(sell[len - 1], cooldown[len - 1]);
    }
}