
public class MatchExp_19 {

	public boolean match(char[] s1,char[] pattern) {
		if (s1==null || pattern == null) {
			return false;
		}
		
		return matchCore(s1,pattern,0,0);
	}
	
	private boolean matchCore(char[] s1,char[] pattern,int s,int p) {
		if (s==s1.length && p==pattern.length) {
			return true;
		}
		
		if (p==pattern.length && s<s1.length) {
			return false;
		}
		
		//第二个字符是*
		if (p<pattern.length-1 && pattern[p+1]=='*') {
			if ((s1[s] == pattern[p] && s<s1.length) || (pattern[p]=='.' && s<s1.length))
			{
				return matchCore(s1, pattern, s+1, p+2) // abc a*bc    abc .*bc
						||matchCore(s1, pattern, s+1, p) // aaac a*c .*c
						||matchCore(s1, pattern, s, p+2); //cb .*cb   a*ab ab
			}
			else {
				return matchCore(s1, pattern, s, p+2);//cb d*b
			}
		}
		// 第二个字符不是*
		if ((s1[s]==pattern[p] && s < s1.length) || (pattern[p] == '.' && s <s1.length)) {
			return matchCore(s1, pattern, s+1, p+1);
		}
		return false;
	}
	
}
