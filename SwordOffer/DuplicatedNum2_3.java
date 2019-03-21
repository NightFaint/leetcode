
public class DuplicatedNum2_3 {

	int findDuplicatedNum(int[] nums,int length)
	{
		if (nums==null || length<=0) {
			return -1;
		}
		int start=1;
		int end=length-1;
		
		while(start<=end)
		{
			int middle=((end-start)>>1)+start;
			int count=countRange(nums, length, start, middle);
			if (start==end) {
				if (count>1) {
					return start;
				}
			}
			if (count>(middle-start+1)) {
				end=middle;
			}
			else {
				start=middle+1;
			}
		}
		return -1;
		
	}
	
	private int countRange(int[] nums,int length,int start,int end)
	{
		if (nums==null) {
			return 0;
		}
		int count=0;
		for(int i:nums)
		{
			if (i<=end && i>=start) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		DuplicatedNum2_3 test=new DuplicatedNum2_3();
		
		int[] test1= {2,3,1,2,5,3};
		int[] test2= {2,3,1,4,6,5};
		int[] test3=null;
		
		int res=0;
		
		res=test.findDuplicatedNum(test1, 6);
		System.out.println(res);
		
		res=test.findDuplicatedNum(test2, 6);
		System.out.println(res);
		
		res=test.findDuplicatedNum(test3, 6);
		System.out.println(res);
	}
}
