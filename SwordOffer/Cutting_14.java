
public class Cutting_14 {

	/*
	 * f(2) = 1，因为只能分成两半
	f(3) = 2，因为分成两段2*1 大于分成三段的1*1*1
	然后根据这两个最优解求出f(4)、f(5)...直到f(n)，每个f(i)的确定是通过遍历所有可能的相乘情况，从中选出乘积最大者。
	 */
	public int dpMaxProductAfterCutting(int length) {
		if (length<2) {
			return 0;
		}
		if (length==2) {
			return 1;
		}
		if (length==3) {
			return 2;
		}
		
		int[] products=new int[length+1];
		products[0]=0;
		products[1]=1;
		products[2]=2;
		products[3]=3;
		
		int max=0;
		for(int i=4;i<=length;i++)
		{
			for(int j=1;j<=i/2;j++)
			{
				int product=products[j]*products[i-j];
				if (max< product) {
					max=product;
				}		
			}
			products[i]=max;
		}
		
		return products[length];
	}
	
	
	/*
	 * 这道题我们按照下面的做法就能得到最优解：如果绳子长度n >= 5，就不断分出长度为3的绳子，
	 * 如果最后只剩下长度为1的绳子，退一步，将得到长度为4的绳子，
	 * 然后将这长度为4的绳子分成2*2(这样分是因为2*2大于原来的3*1)；
	 * 因此n = 4时不能分出长度为3的绳子,而n = 2，n = 3的最优解可直接返回。

	当n >=5时，2*(n-2) > n以及3*(n-3) > n，
	说明当n>5时，应该继续剪长度为2或3的绳子段，
	且给定同样的n，3*(n-3)的值更大，这就是为什么要不断分出长度为3的绳子的原因。
	 */
	public int  greedMaxProductAfterCutting(int length) {
			if (length<2) {
				return 0;
			}
			if (length==2) {
				return 1;
			}
			if (length==3) {
				return 2;
			}
			
			//尽可能多的剪去长度为3的绳子
			int timesOf3=length/3;
			
			if (length-timesOf3*3==1) {
				timesOf3--;
			}
			
			int timesOf2=(length-timesOf3*3)/2;
			
			return (int)(Math.pow(3, timesOf3)*Math.pow(2, timesOf2));
	}
}
