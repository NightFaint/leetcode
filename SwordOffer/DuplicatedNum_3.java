import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatedNum_3 {
	
	//�ȶ���������������ظ�Ԫ������󽫻����ڡ�Ȼ������Ԫ�������Ƚϣ�����ȵ�������ҵ����ظ����֡�����һ������Ϊn������ʱ�临�Ӷ�ΪO(nlg n)��
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
	
	
	//���ù�ϣ��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O��n)
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
	 * ����������ź�����ô����ÿһ��λ�ö���numbers[i] = i��������ظ�Ԫ�أ�˵��[0, n-1]��ĳЩ���ֿ�ȱ�ˣ�
	 * ĳЩ�����ж������ô��Ȼ��ĳ��j !=i��numbers[j] == numbers[i]������ҵ������������������֣�
	 * ���ҵ����ظ����֡�
	 * ���ֵiû������ȷ��λ�ã�����numbers[i] == i����ͨ����������Ԫ�أ���ֵi�ŵ���ȷ��λ�á�������̿��Կ���������
	 * ��numbers[i] != i������numbers[i] = j����Ȼj != i�������ʱnumbers[j] == numbers[i]˵������i��ͬ��λ��j�ҵ��ظ�Ԫ�ء������ظ���һ����
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
