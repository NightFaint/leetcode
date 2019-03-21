
public class LongestSubstring_48 {

	/*
	 * �����ַ���+�...�������뵽��̬�滮
	 * dp[i]��ʾ��i��β�Ĳ������ظ��ַ������ַ����������
	 * �����i���ַ�ǰû�г��ֹ�s[i]��->dp[i]=dp[i-1]+1;
	 * ������ֹ������������
	 * 1.s[i]���ϴγ��ֵ�λ�õľ���dС�ڻ����dp[i-1]����dp[i]=d��
	 * 2.d>dp[i-1],��dp[i]=dp[i-1]+1
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
	 * û���ַ���-1
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
	 * ��ָoffer�ⷨ
	 * O(n)
	 */
	
	public int findLongestSubstring(String str) {
        int curLen = 0;
        int maxLen = 0;
        // 0~25��ʾa~z��position[0] = index,����a�ϴγ�����index��
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int preIndex = position[str.charAt(i) - 'a'];
            // �ַ���һ�γ��֣�����d > f(i -1)
            if (preIndex == -1 || i - preIndex > curLen) curLen++;
            // d <= f(i -1) 
            else curLen = i - preIndex;
            // ��¼��ǰ�ַ����ֵ�λ��
            position[str.charAt(i) - 'a'] = i;
            if (curLen > maxLen) maxLen = curLen;
        }
        return maxLen;
    }
}

