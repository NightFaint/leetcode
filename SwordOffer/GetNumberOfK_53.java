
public class GetNumberOfK_53 {

	/*
	 * 排序数组+查找-》二分法
	 * 用二分查找找出k，然后向左以及向右统计k的个数，
	 * 复杂度和从头开始检查是不是k然后统计个数是相同的，O(n)
	 * 需要改进
	 * 
	 * 用二分查找分别找出第一个k（找到k时检查前一个数是不是k，如果不是则是第一个k，如果是，继续查找前一段）
	 * 和最后一个k，复杂度均为O(lgn)
	 * 总复杂度为O(lg)
	 */
	
	public int getNumberOfK(int[] array,int k) {
		if (array==null || array.length==0) {
			return 0;
		}
		int left=getFirstK(array, k);
		int right=getLastK(array, k);
		if (left>-1 && right>-1) {
			return right-left+1;
		}
		return 0;
	}
	
	private int getFirstK(int [] array,int k) {
		int low=0;
		int high=array.length-1;
		int result=-1;
		while(low<=high)//注意等于号
		{
			int mid=(low+high)/2;
			//当array[mid]=k且mid=0(无前元素了)或者前一个元素不是k时mid为要找的下标
			if (array[mid]==k &&(mid==0 || (mid>0 && array[mid-1]!=k))) {
				result=mid;//如果数组里有k，循环在这中断
				break;
			}
			else if (array[mid]<k) {
				low=mid+1;
			}
			else {
				high=mid-1;
			}
		}
		return result;
		
	}
	
	private int getLastK(int[] array,int k) {
		int low=0;
		int high=array.length-1;
		int result=-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if (array[mid]==k && (mid==array.length-1 || (mid<array.length-1 && array[mid+1]!=k))) {
				result= mid;
				break;
			}
			else if (array[mid]>k) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		return result;
	}
	
	
	/*
	 * 解法二，因为data中都是整数，所以我们不用搜索k的两个位置，
	 * 而是直接搜索k-0.5和k+0.5这两个数应该插入的位置，然后相减即可。
	 */
	public int getNumberOfK_2(int[] array,int k) {
		return binarySearch(array, k+0.5)-binarySearch(array, k-0.5);
	}
	
	private int binarySearch(int[] array,double k) {
		int low=0;
		int high=array.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if (array[mid]>k) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		int[] array= {1,2,3,3,3,4,4,5};
		int[] array2= {1,2,4,5};
		GetNumberOfK_53 test=new GetNumberOfK_53();
		System.out.println(test.getFirstK(array, 3));
		System.out.println(test.getNumberOfK(array, 4));
		
		System.out.println(test.getNumberOfK_2(array, 5));
	}
}
