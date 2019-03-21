
public class LongestSubstring_48 {

	/*
	 * 这种字符串+最长...很容易想到动态规划
	 * dp[i]表示以i结尾的不包含重复字符的子字符串的最长长度
	 * 如果第i个字符前没有出现过s[i]，->dp[i]=dp[i-1]+1;
	 * 如果出现过，分两种情况
	 * 1.s[i]和上次出现的位置的距离d小于或等于dp[i-1]，则dp[i]=d；
	 * 2.d>dp[i-1],则dp[i]=dp[i-1]+1
	 */
	public int longestSubstringWithoutDuplicated(String string) {
		char[] chars=string.toCharArray();
		int [] dp=new int[string.length()];
		dp[0]=1;
		for(int i=1;i<string.length();i++)
		{
			int d=distance(chars, i);
			if (d>0 && d<=dp[i-1]) {
				dp[i]=d;
			}
			else {
				dp[i]=dp[i-1]+1;
			}
		}
		int max=0;
		for(int i:dp)
		{
			if (i>max) {
				max=i;
			}
		}
		return max;
	}
	
	/*
	 * 没出现返回-1
	 * O(n)
	 */
	private int distance(char[] chars,int i) {
		char target=chars[i];
		int j=0;
		int position=-1;
		while(j<i)
		{
			if (chars[j]==target) {
				position=j;
			}
			j++;
		}
		if (position==-1) {
			return -1;
		}
		else {
			return i-position;
		}
	}
	
	public static void main(String[] args) {
		LongestSubstring_48 test=new LongestSubstring_48();
		String test1="arabcacfr";
		String test2="a";
		String test3="abcbcd";
		System.out.println(test.longestSubstringWithoutDuplicated(test1));
	}
	
	/*
	 * 剑指offer解法
	 * O(n)
	 */
	
	public int findLongestSubstring(String str) {
        int curLen = 0;
        int maxLen = 0;
        // 0~25表示a~z，position[0] = index,表明a上次出现在index处
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int preIndex = position[str.charAt(i) - 'a'];
            // 字符第一次出现，或者d > f(i -1)
            if (preIndex == -1 || i - preIndex > curLen) curLen++;
            // d <= f(i -1) 
            else curLen = i - preIndex;
            // 记录当前字符出现的位置
            position[str.charAt(i) - 'a'] = i;
            if (curLen > maxLen) maxLen = curLen;
        }
        return maxLen;
    }
}

