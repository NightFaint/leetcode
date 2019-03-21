
public class GetTranslationCount_46 {

	/*
	 * ������¶��ϣ���С�Ľ������������ÿһ������Ľ�����Թ���һ��ʹ�ã�Ҳ�������ǰ��մ��ҵ����˳���롣
	 * f(i) = f(i+1) + g(i, i+1)f(i+2), 0 <= i < n
	 * ��������Ĺ�ʽ��Ҳ���������f(n -1)��
	 * Ȼ�����f(n -2)��
	 * ֮�����������ֵ���f(n -3)��Ȼ�����f(n-2)��f(n -3)���f(n -4)һֱ����ֱ�����f(0)
	 */
	public int getTranslationCount(int number) {
		if (number<0) {
			return 0;
		}
		String numberInString=String.valueOf(number);
		return getTranslationCount(numberInString);
	}
	
	private int getTranslationCount(String number) {
		int len=number.length();
		int[] counts=new int[len];
		int count=0;
		for(int i=len-1;i>=0;i--)
		{
			if (i<len-1) {
				count=counts[i+1];
			}
			else {
				count=1;
			}
			if (i<len-1) {
				int digit1=number.charAt(i)-'0';
				int digit2=number.charAt(i+1)-'0';
				int converted=digit1*10+digit2;
				if (converted>=10 && converted<=25) {
					if (i<len-2) {
						count+=counts[i+2];
					}
					else {
						count+=1;
					}
				}
			}
			counts[i]=count;
		}
		
		return counts[0];
		}
}
