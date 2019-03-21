package leetcode;

public class Best_Time_to_Buy_and_Sell_Stock {
	
    public int maxProfit(int[] prices) {
    	if (prices==null || prices.length==0) {
			return 0;
		}
    	
    	
    	int max=0;
    	int minvalue=prices[0];
    	for(int i=1;i<prices.length;i++)
    	{
    		if (prices[i]<minvalue) {
				minvalue=prices[i];
			}
    		else {
				if (prices[i]-minvalue>max) {
					max=prices[i]-minvalue;
				}
			}
    	}
    	return max;
    }

}
