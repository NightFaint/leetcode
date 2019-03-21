
public class GetNumberSameAsIndex_53_3 {

	/*
	 * 很明显二分查找
	 * 当找到的array[mid]大于mid
	 * 由于mid之后的第k项array[mid+k]>=array[mid]+k(整数，递增)>mid+k
	 * 所以mid之后都不符合array[i]=i，忽略
	 * right=mid-1
	 * 同理当array[mid]<mid
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
