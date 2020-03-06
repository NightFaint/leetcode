public class L123_Best_Time_to_Buy_and_Sell_StockIII {
    /**
     * 计算两次L121
     * 首先计算出两个长度与prices相等的一维数组left_max和right_max，其中：
     * left_max[i]表示第0天到第i天，一次投资能够得到的最大利润
     * right_max[i]表示第i天到最后一天，一次投资能够得到的最大利润
     *
     * 那么两次投资的最大利润max_earn为从第0天到最后一天left_max[i] + right_max[i+1]的值，即：
     *
     * max_earn = max(left_max[i] + right_max[i+1]) (0≤i≤n)
     *
     * 借鉴 121. 买卖股票的最佳时机的思路，我们已经能够通过O(n)的算法计算left_max和right_max，详见代码，保证一看就懂。最后求max_earn一个遍历就能得到，总体时间复杂度和空间复杂度都是O(n)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int[] leftMax = new int[prices.length];
        int[] rightMax = new int[prices.length];
        int minValue = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++) {

            if(prices[i] < minValue) {
                minValue = prices[i];
            } else {
                int cur = prices[i] - minValue;
                if(cur > max) {
                    max = cur;
                }
            }
            leftMax[i] = max;
        }

        int maxValue = prices[prices.length - 1];
        max = 0;
        for(int i = prices.length - 2; i >= 0; i--) {
            if(prices[i] > maxValue) {
                maxValue = prices[i];
            } else {
                int cur = maxValue - prices[i];
                if(cur > max) {
                    max = cur;
                }
            }
            rightMax[i] = max;
        }
        int max_earn = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            int left = leftMax[i];
            int right = rightMax[i];
            if(left + right > max_earn) {
                max_earn = left + right;
            }

        }
        return max_earn;
    }
}
