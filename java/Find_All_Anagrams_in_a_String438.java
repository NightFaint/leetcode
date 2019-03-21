package leetcode;
import java.util.*;

public class Find_All_Anagrams_in_a_String438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        int n=s.length();
        int m=p.length();
        for(int i=0;i<n-m+1;i++)
        {
        	if(comstring(s.substring(i, i+m), p))
        		res.add(i);
        }
        return res;
        
        
    }
    
    public boolean comstring(String s1,String s2) {
    	if(s1==null||s2==null||s1.length()!=s2.length())
    		return false;
    	int[] arr1=new int[26];
    	for(int i=0;i<s1.length();i++)
    	{
    		arr1[s1.charAt(i)-'a']++;
    	}
    	for(int i=0;i<s2.length();i++)
    	{
    		arr1[s2.charAt(i)-'a']--;
    		if(arr1[s2.charAt(i)-'a']<0)
    			return false;
    	}
    	return true;
    	
		
	}

}
