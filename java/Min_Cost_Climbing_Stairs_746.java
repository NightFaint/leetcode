

public class Min_Cost_Climbing_Stairs_746 {
	
	/*
	 * 动态规划
	 * 子问题关联
	 * dp[i]=min(dp[i+1]+cost[i],dp[i+2]+cost[i])
	 * 复杂度O(n),17ms
	 */
    public int minCostClimbingStairs1(int[] cost) {
    	int [] dp=new int[cost.length+1];
    	dp[cost.length]=0;
    	dp[cost.length-1]=cost[cost.length-1];
    	for(int i=cost.length-2;i>-1;i--)
    	{
    		dp[i]=Math.min(cost[i]+dp[i+1], cost[i]+dp[i+2]);
    	}
    	return Math.min(dp[0], dp[1]);
        
    }
    

    
   

}
