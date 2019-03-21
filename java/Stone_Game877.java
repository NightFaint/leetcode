package leetcode;

/*
��̬�滮
�����������ʽ��
dp[i,j]=max{
 min(dp[i+1,j-1],dp[i+2,j])+piles[i],   #����˫������ȡ���Ų��ԣ������ֵ��Է�ʱ����ѡȡ���Լ����ŵĲ��ԣ�ʹ�ö����ҷ�min(dp[i+1,j-1],dp[i+2,j])
 min(dp[i,j-2],dp[i+1,j-1])+piles[j]    #����dp[i,j],j<i�������û���壬dp[i,j]=0
        }
�����ҷ�����ȡ������ʯͷ��

���Ӷ�O(n**2)
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
