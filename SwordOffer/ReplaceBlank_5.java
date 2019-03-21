
public class ReplaceBlank_5 {

	/*
	 * ����һ��˼ά����ϰ�ߴ������Ҵ����ַ�����
	 * ��������һ���ո�ʱ�����������ַ�����Ҫ��������λ�ã�
	 * �������ڶ����ո�ʱ�������ַ���Ҫ����...��˺ܶ��ַ����ƶ��˲�ֹһ�Ρ�
	 * �ܲ��ܼ����ƶ��Ĵ����أ���ǰ����ɨ��Ҫ�ƶ���ô��Σ������������Ӻ���ǰɨ�����ԡ�

	*�ȱ���һ��ԭ�ַ�����ͳ�ƿո��ַ��ĸ�����
	*����Ҫ���ո�һ���ַ������%20�������ַ�����������Ҫ��ԭ�ַ�������2 * �ո���
	*��������ָ�룬һ��ָ��oldPָ��ԭ�ַ�����ĩβ��
	*��һ��ָ��newPָ������������ַ���ĩβ��
	*���Ͻ�oldP�����ַ��ƶ���newP����Ȼ������ָ�붼Ҫ���ƣ�
	*���oldP���ַ��ǿո񣬾���newP�����������ַ�����˳��ֱ���0��2��%��ͬ��������ָ����Ӧ�����ơ�
	 */
	public String replaceBlank(StringBuffer str) {
		if (str==null) {
			return null;
		}
		
		
		int countSpace=0;
		for(int i=0;i<str.length();i++)
		{
			if (str.charAt(i)==' ') {
				countSpace++;
			}
		}
		
		int oldP=str.length()-1;
		str.setLength(str.length()+2*countSpace);
		
		int newP=str.length()-1;
		
		while(oldP>=0 && newP>oldP)
		{
			if (str.charAt(oldP)==' ') {
					str.setCharAt(newP--, '0');
					str.setCharAt(newP--, '2');
					str.setCharAt(newP--, '%');
					
			}
			else {
				str.setCharAt(newP--, str.charAt(oldP));
			}
			oldP--;
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		ReplaceBlank_5 test=new ReplaceBlank_5();
		StringBuffer test1=new StringBuffer(" we are  hero");
		StringBuffer test2=new StringBuffer("wearehero");
		StringBuffer test3=new StringBuffer(" ");
		String string=test.replaceBlank(test1);
		System.out.println(string);
		
		string=test.replaceBlank(test2);
		System.out.println(string);
		
		string=test.replaceBlank(test3);
		System.out.println(string);
		

	}
}
