
public class findNumMoreThanHalf_39 {

	public int findNumMoreThanHalf(int nums[]) {
		if (nums==null || nums.length==0) {
			return 0;
		}
		int result=nums[0];
		int times=1;
		for(int i=1;i<nums.length;i++)
		{
			if (result==nums[i]) {
				times++;
			}
			else {
				times--;
			}
			if (times==0) {
				result=nums[i];
				times=1;
			}
		}
		return checkMoreThanHalf(nums, result);
	}
	
	
	/**
    * 是否超过数组元素个数的一半，若没有默认返回0
    */
	private int checkMoreThanHalf(int[] nums,int target) {
		int count=0;
		for(int num:nums)
		{
			if (num==target) {
				count++;
			}
		}
		return count>nums.length/2?target:0;
		
	}
}
