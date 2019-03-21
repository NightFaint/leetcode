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
     * ��N%2,��ɵõ�N������ʱ���λ������(Ϊ1��0��,ÿ���ٳ���2���൱��������һλ����˱��ܵõ�N�Ķ����Ʊ�ʾ
     */
    
    public int binaryGap2(int N)
    {
    	int max=0,cur=0,lastseen=-1,temp=0;
    	while(N!=0)
    	{
    		temp=N%2;
    		if (temp==1) {
				if (lastseen!=-1) //����λ��һ�γ���1ʱ����������� 
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
