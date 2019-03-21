

public class MoreThanHalf_39 {

	public int MoreThanHalfNum(int[] nums) {
		if (nums==null||nums.length==0) {
			return 0;
		}
		int mid=select(nums, nums.length>>1);
		return checkMoreThanHalf(nums, mid);
	}

	/**
    * ͳ����λ���Ƿ񳬹�����Ԫ�ظ�����һ�룬��û��Ĭ�Ϸ���0
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
	
	/**
     * ѡ������Ϊk��Ԫ��,ֻ�ǲ�������ʱ�临�Ӷ�ΪO(N)
     */
	private int select(int[] nums,int k) {
		int low=0;
		int high=nums.length-1;
		while(low<high)
		{
			int j=partition(nums, low, high);
			if (j==k) {
				break;
			}
			if (j<k) {
				low=j+1;
			}
			if (j>k) {
				high=j-1;
			}
		}
		return nums[k];
	}
	
	/**
     * ����������зַ���
     */
	private int partition(int[] nums,int low,int high) {
		int val=nums[high];
		int i=low-1;
		for(int j=low;j<high;j++)
		{
			if (nums[j]<val) {
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i+1, high);
		return i+1;
	}
	
	private void swap(int[] nums,int x,int y) {
		int temp=nums[x];
		nums[x]=nums[y];
		nums[y]=temp;
	}
}
