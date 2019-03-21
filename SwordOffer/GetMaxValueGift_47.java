
public class GetMaxValueGift_47 {

	/*
	 * 很明显是一道动态规划
	 * 动态规划的关键是找出一个状态如何由之前的状态得出
	 * 若以f(i,j)代表停在坐标(i,j)时所能获得的礼物最大值，则很明显只有两种可能到达(i,j),
	 * 第一有f(i-1,j)往下，第二有f(i,j-1)往右
	 * 则f(i,j)=max{f(i-1.j),f(i,j-1)} + gift(i,j)
	 * 这一步想通了，其他就简单了
	 */
	public int getMaxValueGift(int[][]gift) {
		if (gift==null || gift.length==0) {
			return 0;
		}
		int m=gift.length;
		int n=gift[0].length;
		
		int[][] dp=new int[m][n];
		dp[0][0]=gift[0][0];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				int up=0;//表示f(i-1,j)
				int left=0;//表示f(i,j-1)
				if (i>0) {
					up=dp[i-1][j];
				}
				if (j>0) {
					left=dp[i][j-1];
				}
				dp[i][j]=Math.max(up, left)+gift[i][j];
			}
		}
		return dp[m-1][n-1];
	}
	
	
	/*
	 * 优化：
	 * 当前礼物的最大价值只依赖f(i-1, j)和f(i, j -1)这两个格子，
	 * 因此只需要当前行i，第j列的前面几个格子，也就是f(i, 0)f(i, j-1)；
	 * 以及i -1行的，第j列及其之后的几个格子，也就是f(i-1, j)f(i-1, cols-1)
	 * 两部分加起来的个数刚好是棋盘的列数cols。所以只需要一个长度为cols的一维数组即可，优化如下。
	 */
	public int getMaxValueGift2(int[][] gift) {
		if (gift==null || gift.length==0) {
			return 0;
		}
		int m=gift.length;
		int n=gift[0].length;
		int[] dp=new int[n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				int up=0;
				int left=0;
				if (i>0) {
					up=dp[j];
				}
				if (j>0) {
					left=dp[j-1];
				}
				dp[j]=Math.max(up, left)+gift[i][j];
			}
		}
		return dp[n-1];
	}
}
