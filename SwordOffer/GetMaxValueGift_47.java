
public class GetMaxValueGift_47 {

	/*
	 * ��������һ����̬�滮
	 * ��̬�滮�Ĺؼ����ҳ�һ��״̬�����֮ǰ��״̬�ó�
	 * ����f(i,j)����ͣ������(i,j)ʱ���ܻ�õ��������ֵ���������ֻ�����ֿ��ܵ���(i,j),
	 * ��һ��f(i-1,j)���£��ڶ���f(i,j-1)����
	 * ��f(i,j)=max{f(i-1.j),f(i,j-1)} + gift(i,j)
	 * ��һ����ͨ�ˣ������ͼ���
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
				int up=0;//��ʾf(i-1,j)
				int left=0;//��ʾf(i,j-1)
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
	 * �Ż���
	 * ��ǰ���������ֵֻ����f(i-1, j)��f(i, j -1)���������ӣ�
	 * ���ֻ��Ҫ��ǰ��i����j�е�ǰ�漸�����ӣ�Ҳ����f(i, 0)f(i, j-1)��
	 * �Լ�i -1�еģ���j�м���֮��ļ������ӣ�Ҳ����f(i-1, j)f(i-1, cols-1)
	 * �����ּ������ĸ����պ������̵�����cols������ֻ��Ҫһ������Ϊcols��һά���鼴�ɣ��Ż����¡�
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
