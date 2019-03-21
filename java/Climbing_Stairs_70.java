package leetcode;

/*
 * dynamic program
 * subproblem relationship:dp[i]=dp[i-1]+dp[i-2]
 * calculation complex:O(n),n subproblems,which each O(1)
 * 2ms,beats 100%
 */
public class Climbing_Stairs_70 {
	
    public int climbStairs(int n) {
    	int[] dp=new int[n+1];
    	dp[0]=1;
    	dp[1]=1;
    	for(int i=2;i<=n;i++)
    	{
    		dp[i]=dp[i-1]+dp[i-2];
    	}
    	
    	return dp[n];
        
    }
}
