
public class FirstAppearOnceChar_50 {

	/*
	 * �����ȱ���һ�Σ�ͳ��ÿ���ַ����ִ������ٱ���һ�Σ�
	 * ����ĳ���ַ������ַ�Ϊ1���������ء�**ͳ��ÿ���ַ����ִ�����
	 * �����ù�ϣ��������������ж���ASCII�룬��ôʹ��0-255��ʾ���ɡ�
	 * ����ʹ��һ��int[] count = new int[256]���ܴ����ϣ���ˣ�
	 * ��count[someChar] = times���ַ�ʽ��ʾĳ���ַ����ֵĴ�����
	 * ���确a����ASCII����97��
	 * ��ôcount[97]�ͱ�ʾ���ַ�'a'�ĳ��ִ������Դ����ơ�
	 */
	public char firstAppearOnceChar(String string) {
		if (string==null || string.length()==0) {
			return '\0';
		}
		
		//�ռ临�Ӷ�O(1) 256-������
		int[] count=new int[256];
		
		//O(n)
		for(int i=0;i<string.length();i++)
		{
			count[string.charAt(i)]++;
		}
		//O(n)
		for(int i=0;i<string.length();i++)
		{
			if (count[string.charAt(i)]==1) {
				return string.charAt(i);
			}
		}
		return '\0';
	}
}
