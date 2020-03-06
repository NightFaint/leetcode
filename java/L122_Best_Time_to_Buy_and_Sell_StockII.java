public class L122_Best_Time_to_Buy_and_Sell_StockII {
    public int maxProfit(int[] prices) {
        // 贪心
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int pre = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < pre) {
                pre = prices[i];
            } else {
                if(prices[i] > pre) {
                    profit += prices[i] - pre;
                    pre = prices[i];
                }
            }
        }
        return profit;
    }
}
