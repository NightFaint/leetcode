import java.util.ArrayList;
import java.util.List;

public class GetKLeastNumbers_40 {

	public List<Integer> getKleastNumbers(int[] nums,int k) {
		List<Integer> list=new ArrayList<>();
		if (nums==null || nums.length==0) {
			return list;
		}
		select(nums, k-1);
		for(int i=0;i<k;i++)
		{
			list.add(nums[i]);
		}
		return list;
	}
	
	/*
	 * 选择排序为k(从0开始统计，第k+1),的数返回，时间复杂度O(n)
	 */
	private int select(int nums[],int k)
	{
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
	/*
	 * 快排中的切分,O(n)
	 */
	private int partition(int nums[],int low,int high) {
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
