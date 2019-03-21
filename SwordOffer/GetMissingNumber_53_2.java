
public class GetMissingNumber_53_2 {

	/*
	 * ����Ϊn-1����������
	 * ÿ�����ַ�Χ0~n-1��Ψһ
	 * ��ת��Ϊ�������������ҳ���һ��ֵ���±겻һ�µ�Ԫ��
	 */
	public int getMissingNumber(int[] array,int length) {
		if (array==null || length<=0) {
			return -1;
		}
		
		int left=0;
		int right=length-1;
		
		while(left<=right)
		{
			int mid=(left+right)>>1;
			if (array[mid] != mid) {
				if (mid==0 || array[mid-1] == mid-1) {
					return mid;
				}
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		
		if (left==length) {
			return left;
		}
		
		return -1;
		
		
	}
}
