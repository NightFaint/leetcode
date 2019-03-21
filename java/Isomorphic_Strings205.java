package leetcode;

import java.lang.annotation.Retention;
import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings205 {
    public  static boolean isIsomorphic(String s, String t) {
        
    	Map<Character, Character> map=new HashMap<>();
    	char[] sc=s.toCharArray();
    	char[] tc=t.toCharArray();
    	for(int i=0;i<s.length();i++)
    	{
    		if(map.containsKey(sc[i]))
    		{
    			if(!(map.get(sc[i]).equals(tc[i])))
    				return false;
    		}
    		else if(!(map.containsKey(sc[i])) && map.containsValue(tc[i]))
    			return false;
    		else
    			map.put(sc[i], tc[i]);
    	}
    	StringBuilder sb=new StringBuilder();
    	for(char c:sc)
    	{
    		sb.append(map.get(c));
    		System.out.println(map);
    		System.out.println(sb);
    	}
    	String snew=sb.toString();
    	if(snew.equals(t))
    		return true;
    	else
    		return false;
    }
    
    public static void main(String[] args) {
    	
		System.out.println(isIsomorphic("ab", "aa"));
	}
}
