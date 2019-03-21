
public class PrintProbability_60 {

	int max_Value=6;

	/*
	 * 递归版本
	 */
	public void printProbability(int number) {
		if (number<1) {
			return;
		}
		
		int max_Sum=number*max_Value;
		int[] probability=new int[max_Sum-number+1];
		getProbability(number, probability);
		
		int total=(int) Math.pow(max_Value, number);
		for(int i=number;i<=max_Sum;i++)
		{
			double ratio=(double)probability[i-number]/total;
			System.out.printf("%d:%e\n",i,ratio);
		}
		
	}
	
	private void getProbability(int number,int[] probability) {
		for(int i=1;i<=max_Value;i++)
			getProbability(number,number,i,probability);
	}
	
	private void getProbability(int origin,int current,int sum,int[] probability)
	{
		if (current==1) {
			probability[sum-origin]++;
		}
		else {
			for(int i=1;i<=max_Value;i++)
			{
				getProbability(origin, current-1, sum+i, probability);
			}
		}
	}
	
	/*
	 * 循环版本：动态规划
	 * f(k,s)=∑f(k−1,s−i),1≤i≤6,s>i,表示k个骰子总数为s的次数
	 */
	public void printProbability2(int number) {
		if (number<1) {
			return;
		}
		int max_Sum=number*max_Value;
		int[][] f=new int[number+1][max_Sum+1];
		for(int i=1;i<=max_Value;i++)
		{
			f[1][i]=1;
		}
		
		for(int k=2;k<=number;k++)
		{
			for(int sum=k;sum<=k*max_Value;sum++)
			{
				for(int i=1;sum>i && i<=max_Value;i++)
					f[k][sum]+=f[k-1][sum-i];
			}
		}
		
		int total=(int)Math.pow( max_Value,number);
		for(int sum=number;sum<=number*max_Value;sum++)
		{
			System.out.printf("s = %d: %f%n",sum,(double)f[number][sum]/total);
		}
	}
	
	public static void main(String[] args) {
		PrintProbability_60 test=new PrintProbability_60();
		test.printProbability2(3);
		test.printProbability(3);
	}
}
