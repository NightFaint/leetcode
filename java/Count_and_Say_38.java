package leetcode;

import java.util.Stack;

public class Count_and_Say_38 {

	//9ms,»÷°Ü29%
    public String countAndSay(int n) {
    	if (n==1) {
			return "1";
		}
    	else {
			String prev=this.countAndSay(n-1);
			StringBuilder sBuilder=new StringBuilder();
			Stack<Integer> stack=new Stack<>();
			char[] chars=prev.toCharArray();
			for(int i=0;i<chars.length;i++)
			{
				int j=(int)(chars[i]-'0');
				if (stack.empty()) {
					
					if (i==chars.length-1) {
						sBuilder.append("1"+Integer.toString(j));
					}
					else {
					stack.push(j);}
				}
				else {
					int size=stack.size();
					int ele=stack.peek();
					if (j==stack.peek()) {
						stack.push(j);
						if (i==chars.length-1) {
							sBuilder.append(Integer.toString(size+1)+Integer.toString(ele));
						}
					}
					else {
						sBuilder.append(Integer.toString(size)+Integer.toString(ele));
						stack.clear();
						stack.push(j);
						if (i==chars.length-1) {
							sBuilder.append("1"+Integer.toString(j));
						}
					}
				}
				
			}
			return sBuilder.toString();
			
		}
    	
        
    }
    
    //3ms,»÷°Ü89%
    public String countAndSay2(int n)
    {
    	if (n==1) {
			return "1";
		}
    	if (n==2) {
			return "11";
		}
    	String prev="11";
    	for(int i=3;i<=n;i++)
    	{
    		int count=1;
    		char[] chars=prev.toCharArray();
    		StringBuilder sBuilder=new StringBuilder();
    		for(int j=1;j<chars.length;j++)
    		{
    			if (chars[j]==chars[j-1]) {
					count++;
				}
    			else {
					sBuilder.append(count);
					sBuilder.append(chars[i-1]);
					count=1;
				}
    		}
    		sBuilder.append(count);
    		sBuilder.append(chars[chars.length-1]);
    		prev=sBuilder.toString();
    	}
    	return prev;
    }
}
