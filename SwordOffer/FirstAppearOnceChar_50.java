
public class FirstAppearOnceChar_50 {

	/*
	 * 可以先遍历一次，统计每个字符出现次数。再遍历一次，
	 * 遇到某个字符出现字符为1就立即返回。**统计每个字符出现次数，
	 * 可以用哈希表，不过如果输入中都是ASCII码，那么使用0-255表示即可。
	 * 这样使用一个int[] count = new int[256]就能代替哈希表了，
	 * 以count[someChar] = times这种方式表示某个字符出现的次数。
	 * 比如‘a’的ASCII码是97，
	 * 那么count[97]就表示了字符'a'的出现次数，以此类推。
	 */
	public char firstAppearOnceChar(String string) {
		if (string==null || string.length()==0) {
			return '\0';
		}
		
		//空间复杂度O(1) 256-》常数
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
