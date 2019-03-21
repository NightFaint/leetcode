package leetcode;

public class Binary_Gap_868 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Integer.toBinaryString(5));
	}
	
    public int binaryGap(int N) {
        String binary=Integer.toBinaryString(N);
        int count=0;
        int start=binary.indexOf("1");
        int end=0;
        if (start<0) {
			return 0;
		}
        for(int i=start+1;i<binary.length();i++)
        {
        	if(binary.charAt(i)=='1')
        	{
        		end=i;
        		count=Math.max(count, end-start);
        		start=end;
        	}
        }
        return count;
    }
    
    
    /*
     * 将N%2,便可得到N二进制时最低位的数字(为1或0）,每次再除以2，相当于向右移一位。如此便能得到N的二进制表示
     */
    
    public int binaryGap2(int N)
    {
    	int max=0,cur=0,lastseen=-1,temp=0;
    	while(N!=0)
    	{
    		temp=N%2;
    		if (temp==1) {
				if (lastseen!=-1) //当低位第一次出现1时，不计算距离 
				{
					max=Math.max(max, cur-lastseen);
					
				}
				lastseen=cur;
			}
    		N/=2;
    		++cur;
    	}
    	return max;
    	
    }

}
