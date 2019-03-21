
public class Cutting_14 {

	/*
	 * f(2) = 1����Ϊֻ�ֳܷ�����
	f(3) = 2����Ϊ�ֳ�����2*1 ���ڷֳ����ε�1*1*1
	Ȼ��������������Ž����f(4)��f(5)...ֱ��f(n)��ÿ��f(i)��ȷ����ͨ���������п��ܵ�������������ѡ���˻�����ߡ�
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
	 * ��������ǰ���������������ܵõ����Ž⣺������ӳ���n >= 5���Ͳ��Ϸֳ�����Ϊ3�����ӣ�
	 * ������ֻʣ�³���Ϊ1�����ӣ���һ�������õ�����Ϊ4�����ӣ�
	 * Ȼ���ⳤ��Ϊ4�����ӷֳ�2*2(����������Ϊ2*2����ԭ����3*1)��
	 * ���n = 4ʱ���ֳܷ�����Ϊ3������,��n = 2��n = 3�����Ž��ֱ�ӷ��ء�

	��n >=5ʱ��2*(n-2) > n�Լ�3*(n-3) > n��
	˵����n>5ʱ��Ӧ�ü���������Ϊ2��3�����ӶΣ�
	�Ҹ���ͬ����n��3*(n-3)��ֵ���������ΪʲôҪ���Ϸֳ�����Ϊ3�����ӵ�ԭ��
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
			
			//�����ܶ�ļ�ȥ����Ϊ3������
			int timesOf3=length/3;
			
			if (length-timesOf3*3==1) {
				timesOf3--;
			}
			
			int timesOf2=(length-timesOf3*3)/2;
			
			return (int)(Math.pow(3, timesOf3)*Math.pow(2, timesOf2));
	}
}
