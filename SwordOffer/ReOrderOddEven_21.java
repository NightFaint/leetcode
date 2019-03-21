import java.util.Arrays;

public class ReOrderOddEven_21 {

	/*
	 * ���ÿ���partition��˼�룬��һ��ָ�붨λ�������е�λ�ã���һ��ָ��������顣
	 */
	public void reOrderOddEven(int[] nums) {
		if (nums==null || nums.length<=1) {
			return;
		}
		int i=-1;
		for(int j=0;j<nums.length;j++)
		{
			if ((nums[j] & 1)==1) //����λ����
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
	 * ��ָoffer�Ͻⷨ��˼���������ͬС��
	 * ��������ָ�룬һ��ָ��pBeginָ�������һ��Ԫ�أ�һ��ָ��pEndָ����������һ��Ԫ�أ�
	 * ��pBegin < pEndʱ��pBeginָ�벻�����ƣ�ֱ������ĳ��ż��Ϊֹ��ͬ���ģ�pEnd�������ƣ�ֱ������ĳ������Ϊֹ��
	 * ����ʱpBegin < pEnd����������Ԫ�أ��������ǰ����������������˺��档
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
