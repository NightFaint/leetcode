package leetcode;

public class PLUS_ONE_66 {
	
    public static int[] plusOne(int[] digits) {
        if(digits==null)
            return digits;
        if(digits.length==0)
            return new int[]{1};
        int x=digits[digits.length-1]+1;
        if (x>9) {
			int[] prev=new int[digits.length-1];
			for(int i=0;i<digits.length-1;i++)
				prev[i]=digits[i];
			int[] prevRes=plusOne(prev);
			int[] result=new int[prevRes.length+1];
			result[result.length-1]=0;
			for(int i=0;i<prevRes.length;i++)
				result[i]=prevRes[i];
			return result;
		}
        else
        {
        	digits[digits.length-1]=x;
        	return digits;
        }
        
    	
    }
    
    public static int[] plusOne2(int[] digits) {
    	
    	int count=0;
    	for(int i=digits.length-1;i>=0;i--)
    	{
    		int x=digits[i]+1;
    		int r=x%10;
    		if (r==0) {
				digits[i]=0;
				count++;
			}
    		else {
				digits[i]=x;
				return digits;
			}
    	}
    	if (count==digits.length)
    	{
    		int[] result=new int[digits.length+1];
    		result[0]=1;
    		for(int i=1;i<result.length;i++)
    			result[i]=digits[i-1];
			return result;
		}
    	else {
			return digits;
		}
    }
    
    public static void main(String[] args) {
		plusOne(new int[] {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6});
	}

}
