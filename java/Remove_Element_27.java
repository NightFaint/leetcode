package leetcode;

/*
 * ���Ӷ�O(n)
 * ����99.84%
 * �տ�ʼ˼·�Ǳ������飬����Ŀ��ֵ������������ƶ�һλ������ĩβ���Ŀ��ֵ����Ȼ���ӶȴﵽO(n**2)��
 * �����뵽����������ĩβ���һ��ָ�룬��ָ���ұ�ȫ��Ŀ��ֵ��������������ģ�ͬ���������ұ������飬
 * ������Ŀ��ֵʱ���жϵ�ǰright�Ƿ���Ŀ��ֵ�����ǣ���right��1(ע���ʱҪ�ж�i�Ƿ����right�����ǣ�����ֱ��ֹͣ�����õ����)��
 * ֱ���ҵ�һ����Ŀ��ֵΪֹ��Ȼ��nums[i]��nums[right]����λ�ã��ٽ�right��1.
 * ��Ȼ������������i��right��ʱ����ֹͣ��������ʱ��i+1��ɼ���ֵ(������0��ʼ)��
 */

public class Remove_Element_27 {
	
    public static int removeElement(int[] nums, int val) {
    	int count=0;
    	int right=nums.length-1;
    	tag:
    	for(int i=0;i<nums.length;i++)
    	{
    		if (i>right) {
				break;
			}
    		if (nums[i]==val) {
				while(nums[right]==val )
				{
					right--;
                    if(i>right)
                        break tag;
					
				}
				nums[i]=nums[right];
				nums[right]=val;
				right--;
			}
    		count++;
    	}
        return count;
    }

    public static void main(String[] args) {
		int i=removeElement(new int[] {1}, 1);
		System.out.println(i);
	}

}
