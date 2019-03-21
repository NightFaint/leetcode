
public class FindIn2DArray_4{

	/* ���ھ�����ϵ��µ����������ҵ�����
      * ���ǺͶ�ά��������Ͻ�Ԫ�رȽϣ��ԳƵأ����½�Ҳ���ԣ�
      * ���Ŀ������ϽǵĴ�ɾ�����У���ָ�������ƶ�����������Ͻǵ�С��ɾ�����У���ָ������
	 */
	public boolean find(int target ,int[][] array) {
		if (array!=null && array.length>0) {
			int rowLen=array.length;
			int colLen=array[0].length-1;
			int row=0;
			
			while(row<rowLen && colLen>=0)
			{
				if (target<array[row][colLen]) {
					colLen--;
				}
				else if (target > array[row][colLen]) {
					row++;
				}
				else {
					return true;
				}
			}
			return false;
		}
		return false;	
		
	}
	/*
	 * ÿһ�е�һά�����Ѿ���������ʹ�ö��ֲ�����ÿһ���в��ң�
	 * һ���ҵ��������ء�����һ��M*N�Ķ�ά���飬һ�ζ��ֲ��ҵ�ʱ�临�Ӷ�ΪO(lg N),
	 *  M�о���O(Mlg N)��
	 */
	public boolean Find2(int target, int[][] array)
	{
		if (array!=null && array.length >0) {
			for(int i=0;i<array.length;i++)
			{
				int low=0;
				int high=array[i].length-1;
				while(low<=high)
				{
					int middle=((high-low)>>1)+low;
					if (target==array[i][middle]) {
						return true;
					}
					else if (target > array[i][middle]) {
						low=middle+1;
					}
					else {
						high=middle-1;
					}
				}
				
			}
			return false;
				
		}
		return false;	
	}
	
	
	public static void main(String[] args) {
		String s1="abc";
		String s2="abc";
		String s3=new String("abc");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
	}
}
