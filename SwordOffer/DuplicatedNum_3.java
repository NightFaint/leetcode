import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatedNum_3 {
	
	//先对数组排序，如果有重复元素排序后将会相邻。然后相邻元素两两比较，有相等的情况就找到了重复数字。排序一个长度为n的数组时间复杂度为O(nlg n)。
	public  List<Integer> duplicated(int[] nums,int length) {
		if (nums==null || length<=0) {
			return null;
		}
		List<Integer> res=new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<length-1;i++)
		{
			if (nums[i]==nums[i+1]) {
				res.add(nums[i]);
				i++;
			}
		}
		return res;
		
	}
	
	
	//利用哈希表，时间复杂度O(n)，空间复杂度O（n)
	public List<Integer> duplicated2(int[] nums,int length)
	{

		List<Integer> res=new ArrayList<>();
		if (nums==null || length<=0) {
			return null;
		}
		Set<Integer> hashSet=new HashSet<>();
		for(int i:nums)
		{
			if (!hashSet.contains(i)) {
				hashSet.add(i);
			}
			else {
				res.add(i);
			}
		}
		return res;
	}
	
	/*
	 * 如果将数组排好序，那么数组每一个位置都有numbers[i] = i，如果有重复元素，说明[0, n-1]中某些数字空缺了，
	 * 某些数字有多个。那么必然有某个j !=i的numbers[j] == numbers[i]，如果找到满足上述条件的数字，
	 * 就找到了重复数字。
	 * 如果值i没有在正确的位置（满足numbers[i] == i），通过交换两个元素，将值i放到正确的位置。这个过程可以看成是排序
	 * 当numbers[i] != i，若令numbers[i] = j，显然j != i；如果此时numbers[j] == numbers[i]说明在与i不同的位置j找到重复元素。否则重复上一步。
	 */
	public List<Integer> duplicated3(int[] nums,int length)
	{

		
		List<Integer> res=new ArrayList<>();
		
		if (nums==null || length<=0) {
			return null;
		}
		for(int i:nums)
		{
			if (nums[i]<0 || nums[i]>length-1) {
				return res;
			}
		}
		
		Set<Integer> resset=new HashSet<>();
		for(int i=0;i<length-1;i++)
		{
			while(nums[i]!=i)
			{
				if (nums[i] == nums[nums[i]]) {
					if (!resset.contains(nums[i])) {
						resset.add(nums[i]);
					}
					break;
				}
				swap(nums, i, nums[i]);
				
			}
		}
		res=new ArrayList<>(resset);
		return res;
		
	}
	
	private void swap(int[] nums,int x,int y)
	{
		int temp=nums[x];
		nums[x]=nums[y];
		nums[y]=temp;
	}
	
	public static void main(String[] args) {
		List<Integer> res=new ArrayList<>();
		
		int[] test1= {2,3,1,0,2,5,3};
		int[] test2= {2,3,1,0,4,6,5};
		int[] test3=null;
		
		DuplicatedNum_3 test=new DuplicatedNum_3();
		
		res=test.duplicated(test1, 7);
		System.out.println(res);
		
		res=test.duplicated(test2, 7);
		System.out.println(res);
		
		res=test.duplicated(test3, 7);
		System.out.println(res);
		
		res=test.duplicated2(test1, 7);
		System.out.println(res);
		
		res=test.duplicated2(test2, 7);
		System.out.println(res);
		
		res=test.duplicated2(test3, 7);
		System.out.println(res);
		
		
		res=test.duplicated3(test1, 7);
		System.out.println(res);
		
		res=test.duplicated3(test2, 7);
		System.out.println(res);
		
		res=test.duplicated3(test3, 7);
		System.out.println(res);
				
	}

}
