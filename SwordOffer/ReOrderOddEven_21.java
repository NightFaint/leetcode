import java.util.Arrays;

public class ReOrderOddEven_21 {

	/*
	 * 采用快排partition的思想，用一个指针定位奇数序列的位置，另一个指针遍历数组。
	 */
	public void reOrderOddEven(int[] nums) {
		if (nums==null || nums.length<=1) {
			return;
		}
		int i=-1;
		for(int j=0;j<nums.length;j++)
		{
			if ((nums[j] & 1)==1) //采用位运算
			{
				i++;
				swap(nums, i, j);
			}
		}
	}
	
	private void swap(int[] nums,int i,int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	
	/*
	 * 剑指offer上解法，思想与上面大同小异
	 * 设置两个指针，一个指针pBegin指向数组第一个元素，一个指针pEnd指向数组的最后一个元素；
	 * 当pBegin < pEnd时：pBegin指针不断右移，直到遇到某个偶数为止；同样的，pEnd不断左移，直到遇到某个奇数为止。
	 * 若此时pBegin < pEnd：交换两个元素，因此排在前面的奇数被交换到了后面。
	 */
	
	public void reOrderOddEven2(int [] nums) {
		if (nums==null || nums.length<=1) {
			return;
		}
		
		int pBegin=0,pEnd=nums.length-1;
		while(pBegin<pEnd)
		{
			while(pBegin<pEnd && (nums[pBegin] & 1)==1)
			{
				pBegin++;

			}
			while(pBegin<pEnd && (nums[pEnd] &1) !=1)
			{
				pEnd--;
			}
			if (pBegin<pEnd) {
				swap(nums, pBegin, pEnd);
			}
		}
	}
	
	public static void main(String[] args) {
		
		ReOrderOddEven_21 test=new ReOrderOddEven_21();
		int[] test1= {2,1,4,5,1,4,7,3};
		int[] test2= {0,3,5,4,3};
		test.reOrderOddEven(test1);
		test.reOrderOddEven(test2);
		System.out.println(Arrays.toString(test1));
		System.out.println(Arrays.toString(test2));
	}
}
