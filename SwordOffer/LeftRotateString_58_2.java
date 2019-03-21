
public class LeftRotateString_58_2 {

	public String rotate(String string,int n) {
		if (string==null || n<0 || n>string.length()) {
			return "";
		}
		
		char[] chars=string.toCharArray();
		reverse(chars, 0, n-1);
		reverse(chars, n, string.length()-1);
		reverse(chars, 0, string.length()-1);
		return new String(chars);
	}
	
	private void reverse(char[] chars,int low,int high) {
		while(low<high)
		{
			char temp=chars[low];
			chars[low] = chars[high];
			chars[high]=temp;
			low++;
			high--;
		}
	}
}
