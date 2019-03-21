package leetcode;

/*
动态规划
子问题关联公式：
dp[i,j]=max{
 min(dp[i+1,j-1],dp[i+2,j])+piles[i],   #由于双方都采取最优策略，所以轮到对方时它会选取对自己最优的策略，使得对于我方min(dp[i+1,j-1],dp[i+2,j])
 min(dp[i,j-2],dp[i+1,j-1])+piles[j]    #对于dp[i,j],j<i的情况，没意义，dp[i,j]=0
        }
对于我方，是取的最大的石头数

复杂度O(n**2)
*/

public class Stone_Game877 {
    public boolean stoneGame(int[] piles) 
    {
        int n=piles.length;
        int[][] dp=new int[n][n];
        for(int len=1;len<=n;len++)
            for(int i=0;i<n-len+1;i++)
            {
                int j=i+len-1;
                int d1=j-1>=i+1 ? dp[i+1][j-1] :0;
                int d2=j>=i+2 ? dp[i+2][j]:0;
                int d3=j-2>=i ?dp[i][j-2]:0;
                int d4=d1;
                int q1 = d1<d2?d1:d2;
                int q2 = d3<d4?d3:d4;
                dp[i][j]=q1+piles[i]>q2+piles[j]?q1+piles[i]:q2+piles[j];
            }
        int sum=0;
        for(int i:piles)
            sum+=i;
        return dp[0][n-1]>sum/2;
        
        
    }

}
