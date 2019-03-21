
public class ReplaceBlank_5 {

	/*
	 * 按照一般思维，总习惯从左往右处理字符串。
	 * 当遇见第一个空格时，其后的所有字符都需要右移两个位置；
	 * 当遇见第二个空格时，其后的字符又要右移...因此很多字符被移动了不止一次。
	 * 能不能减少移动的次数呢？从前往后扫描要移动那么多次，不妨反过来从后往前扫描试试。

	*先遍历一遍原字符串，统计空格字符的个数。
	*由于要将空格（一个字符）变成%20（三个字符），所以需要将原字符串增长2 * 空格数
	*设置两个指针，一个指针oldP指向原字符串的末尾；
	*另一个指针newP指向增长后的新字符串末尾。
	*不断将oldP处的字符移动到newP处，然后两个指针都要左移；
	*如果oldP处字符是空格，就在newP处设置三个字符：按顺序分别是0、2、%，同样的两个指针相应的左移。
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
