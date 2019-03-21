package leetcode;

/**
*˼·��
*��̬�滮���տ�ʼ����dp[i]��dp[i-1]�Ĺ�ϵ�����ֵ�iΪ����ʱ��dp[i]=dp[i-1]+1��ż��ʱ�Ҳ�������
*����˼����i����ʱ��dp[i]=dp[i-1]+1����Ϊi-1�����λΪ0����i�����λΪ1������λ��ͬ��������dp[i]=dp[i-1]+1��
*��ô��ͬ����˼·����i����һλ������dp[i]=dp[i>>1]+(i&1)
*���㸴�Ӷ�O(n)���ռ临�Ӷ�O(n)
*/

public class Counting_Bits338 {
    public int[] countBits(int num) 
    {
        ++num;
        int[] dp=new int[num];
        for(int i=1;i<num;++i)
        {
            dp[i]=dp[i>>1]+(i&1);
        }
        return dp;
    }
}
