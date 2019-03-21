
public class FindIn2DArray_4{

	/* 由于矩阵从上到下递增，从左到右递增。
      * 总是和二维矩阵的右上角元素比较（对称地，左下角也可以）
      * 如果目标比右上角的大，删除该行，行指针向下移动；如果比右上角的小，删除该列，列指针左移
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
	 * 每一行的一维数组已经有序，所以使用二分查找在每一行中查找，
	 * 一旦找到立即返回。对于一个M*N的二维数组，一次二分查找的时间复杂度为O(lg N),
	 *  M行就是O(Mlg N)。
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
