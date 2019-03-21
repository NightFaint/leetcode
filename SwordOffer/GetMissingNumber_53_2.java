
public class GetMissingNumber_53_2 {

	/*
	 * 长度为n-1，递增排序
	 * 每个数字范围0~n-1，唯一
	 * 可转换为在排序数组中找出第一个值和下标不一致的元素
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
