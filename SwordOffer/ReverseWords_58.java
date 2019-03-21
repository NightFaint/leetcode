
public class ReverseWords_58 {

	//�����巴ת���پֲ���ת
	//���ַ������ڵ���֮���ж���ո�����Ҳ����ȷ����
	public String reverseWords(String string) {
		if (string==null) {
			return null;
		}
		char[] chars=string.toCharArray();
		reverse(chars, 0, chars.length-1);
		
		int low=0;
		int high=0;
		while(low<chars.length)
		{
			
			if (chars[low]==' ') {
				low++;
				high++;
			}
//			��תһ�����ʵ������ǵ��ʺ����пո���ߵ��ʵ��ַ����������ַ�����ĩβ
			else if (high==chars.length || chars[high]==' ') {
				/*
				 * ����������--highʹ�����ַ����в����ո�
				 * ֮���++high��ֵ��low����ô�´��ж�low����Ȼ�ǿո�
				 * ��ʱlow == high == ' '��
				 * �������ָ�붼Ҫ����һλ���������ո�
				 */
				reverse(chars, low, --high);
				low=++high;
				
			}
//			���low��high�����ַ������ǿո�˵����û�е����ʵ�ĩβ�����ֱ�ӽ�high���Ƽ��ɡ�
			else {
				high++;
			}
		}
		return new String(chars);
	}
	
	private void reverse(char[] chars,int low,int high) {
		while(low<high)
		{
			char temp=chars[low];
			chars[low]=chars[high];
			chars[high]=temp;
			low++;
			high--;
		}
	}
}
