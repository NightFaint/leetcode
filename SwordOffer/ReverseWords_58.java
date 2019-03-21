
public class ReverseWords_58 {

	//先整体反转，再局部反转
	//这种方法对于单词之间有多个空格的情况也能正确处理。
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
//			翻转一个单词的条件是单词后面有空格或者单词的字符到达整个字符串的末尾
			else if (high==chars.length || chars[high]==' ') {
				/*
				 * 代码中先是--high使得子字符串中不含空格，
				 * 之后后将++high赋值给low，那么下次判断low处必然是空格，
				 * 此时low == high == ' '，
				 * 因此两个指针都要右移一位，以跳过空格。
				 */
				reverse(chars, low, --high);
				low=++high;
				
			}
//			如果low和high处的字符都不是空格，说明还没有到单词的末尾，因此直接将high右移即可。
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
