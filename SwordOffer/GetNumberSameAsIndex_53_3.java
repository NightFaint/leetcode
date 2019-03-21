
public class GetNumberSameAsIndex_53_3 {

	/*
	 * �����Զ��ֲ���
	 * ���ҵ���array[mid]����mid
	 * ����mid֮��ĵ�k��array[mid+k]>=array[mid]+k(����������)>mid+k
	 * ����mid֮�󶼲�����array[i]=i������
	 * right=mid-1
	 * ͬ��array[mid]<mid
	 * left=mid+1
	 */
	public int getNumberSameAsIndex(int[] array,int length) {
		if (array==null || length<=0) {
			return -1;
		}
		
		int left=0;
		int right=length-1;
		while(left<=right)
		{
			int mid=(left+right)>>1;
			if (array[mid]==mid) {
				return mid;
			}
			else if (array[mid]>mid) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		return -1;
	}
}
