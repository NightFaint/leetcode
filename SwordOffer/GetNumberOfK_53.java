
public class GetNumberOfK_53 {

	/*
	 * ��������+����-�����ַ�
	 * �ö��ֲ����ҳ�k��Ȼ�������Լ�����ͳ��k�ĸ�����
	 * ���ӶȺʹ�ͷ��ʼ����ǲ���kȻ��ͳ�Ƹ�������ͬ�ģ�O(n)
	 * ��Ҫ�Ľ�
	 * 
	 * �ö��ֲ��ҷֱ��ҳ���һ��k���ҵ�kʱ���ǰһ�����ǲ���k������������ǵ�һ��k������ǣ���������ǰһ�Σ�
	 * �����һ��k�����ӶȾ�ΪO(lgn)
	 * �ܸ��Ӷ�ΪO(lg)
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
		while(low<=high)//ע����ں�
		{
			int mid=(low+high)/2;
			//��array[mid]=k��mid=0(��ǰԪ����)����ǰһ��Ԫ�ز���kʱmidΪҪ�ҵ��±�
			if (array[mid]==k &&(mid==0 || (mid>0 && array[mid-1]!=k))) {
				result=mid;//�����������k��ѭ�������ж�
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
	 * �ⷨ������Ϊdata�ж����������������ǲ�������k������λ�ã�
	 * ����ֱ������k-0.5��k+0.5��������Ӧ�ò����λ�ã�Ȼ��������ɡ�
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
