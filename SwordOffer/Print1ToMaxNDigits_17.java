
public class Print1ToMaxNDigits_17 {
	
	/*
	 * 大数问题，牵涉到大数问题我们可以将其转化为字符串表示。因为字符串任意长度都行。
	 * 字符串上模拟数字的加法
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
		int toTen=0;// 进位,应该要给下一位相加，所以设置在循环外
		// 从个位开始加，如果有进位就看十位...如果到最高位还有进位，说明溢出；
		for(int i=len-1;i>=0;i--)
		{
			int sum=sb.charAt(i)-'0'+toTen;
			if (i==len-1) {
				sum++;
			}
			
			if (sum==10) {
				if (i==0) {
					return false;// 进位溢出
				}
				else {
					sb.setCharAt(i, '0');
					toTen=1;
				}
			}
			else {
				sb.setCharAt(i, (char)(sum+'0'));
				break;// 在某位上自增后不再进位，自增完成立即退出循环
			}
		}
		return true;
	}
	
	//将字符串表达的数字打印出来，为了可读性需要忽略不必要的0；
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
	
	//递归的方法排列出所有可能的情况
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
