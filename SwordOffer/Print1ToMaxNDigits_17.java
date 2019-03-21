
public class Print1ToMaxNDigits_17 {
	
	/*
	 * �������⣬ǣ�浽�����������ǿ��Խ���ת��Ϊ�ַ�����ʾ����Ϊ�ַ������ⳤ�ȶ��С�
	 * �ַ�����ģ�����ֵļӷ�
	 */
	public void print1ToMaxDigits(int n) {
		if (n<0) {
			return;
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<n;i++)
		{
			sb.append('0');
		}
		while(stillValid(sb, n))
		{
			print(sb);
		}
		
	}
	
	private boolean stillValid(StringBuffer sb,int len) {
		int toTen=0;// ��λ,Ӧ��Ҫ����һλ��ӣ�����������ѭ����
		// �Ӹ�λ��ʼ�ӣ�����н�λ�Ϳ�ʮλ...��������λ���н�λ��˵�������
		for(int i=len-1;i>=0;i--)
		{
			int sum=sb.charAt(i)-'0'+toTen;
			if (i==len-1) {
				sum++;
			}
			
			if (sum==10) {
				if (i==0) {
					return false;// ��λ���
				}
				else {
					sb.setCharAt(i, '0');
					toTen=1;
				}
			}
			else {
				sb.setCharAt(i, (char)(sum+'0'));
				break;// ��ĳλ���������ٽ�λ��������������˳�ѭ��
			}
		}
		return true;
	}
	
	//���ַ����������ִ�ӡ������Ϊ�˿ɶ�����Ҫ���Բ���Ҫ��0��
	private void print(StringBuffer sb) {
		int start=sb.length();
		for(int i=0;i<sb.length();i++)
		{
			if (sb.charAt(i)!='0') {
				start=i;
				break;
			}
		}
		
		if (start<sb.length()) {
			System.out.println(sb.substring(start)+' ');
		}
	}
	
	//�ݹ�ķ������г����п��ܵ����
	public void print1ToMaxDigits2(int n) {
		if (n<=0) {
			return;
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<n;i++)
		{
			sb.append('0');
		}
		printRecursive(sb, n, -1);
	}
	
	private void printRecursive(StringBuffer sb,int len,int index) {
		if (index==len-1) {
			print(sb);
			return;
		}
		for(int i=0;i<10;i++)
		{
			sb.setCharAt(index+1, (char)(i+'0'));
			printRecursive(sb, len, index+1);
		}
		
	}
	
	
	public static void main(String[] args) {
		Print1ToMaxNDigits_17 test=new Print1ToMaxNDigits_17();
		test.print1ToMaxDigits(5);
		test.print1ToMaxDigits2(4);
	}

}
