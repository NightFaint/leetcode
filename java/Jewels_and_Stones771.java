package leetcode;

public class Jewels_and_Stones771 {
	
	
	//∏¥‘”∂»O(mlgn)
    public int numJewelsInStones(String J, String S) {
    	char[] s=S.toCharArray();//O(m)
    	int count=0;
    	for(char c:s)
    	{
    		if(J.indexOf(c)!=-1)//lg(n)
    			count++;
    	}
    	return count;
        
    }
    
    public int numJewelsInStones2(String J, String S) {
    	int[] jewel=new int[128];
    	int count=0;
    	for(int i=0;i<J.length();i++)
    	{
    		jewel[(int)J.charAt(i)]=1;
    	}
    	
    	for(int i=0;i<S.length();i++)
    	{
    		if(jewel[(int)S.charAt(i)]==1)
    			count++;
    	}
    	return count;
        
    }
}
