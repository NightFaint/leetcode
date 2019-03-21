package leetcode;

public class Palindromic_Substrings647 {
    public int countSubstrings(String s) 
    {
        int dp1,dp2;
        int sum=0;
        for(int i=0;i<s.length();++i)
        {
            dp1=assist(s,i,i);
            dp2=assist(s,i,i+1);
            sum+=dp1+dp2;
        }
        return sum;
        
    }
    
    public int assist(String s,int left,int right)
    {
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            count++;
            left--;
            right++;
        }
        return count;
            
        
    }
}
