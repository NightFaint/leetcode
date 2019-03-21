package leetcode;

/*
 * 3 ms, faster than 100.00% of Java online submissions for House Robber.
 * 动态规划，复杂度O(n),空间复杂度O(n)
 */

public class House_Robber_198 {
	
    public int rob(int[] nums) {
        int n=nums.length;
        if(nums==null || n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return nums[0];
        }
        if(n==2)
        {
            return Math.max(nums[0],nums[1]);
        }

    	int dp[]=new int[n+1];
    	dp[n]=0;
    	dp[n-1]=nums[n-1];
    	dp[n-2]=nums[n-2];
    	for(int i=n-3;i>-1;i--)
    	{
    		dp[i]=nums[i]+Math.max(dp[i+2], dp[i+3]);
    	}
    	return Math.max(dp[0], dp[1]);
    }

}
