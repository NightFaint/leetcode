
public class AppearOnceInStream_50 {

	private int[] count=new int[256];//统计字符次数
	private int index;//记录是第几个读入的字符
	
	public AppearOnceInStream_50() {
		// TODO Auto-generated constructor stub
		for(int i=0;i<count.length;i++)
			count[i]=-1;
	}
	
	// 模拟读取字符流中的下一个字符
	public void insert(char c) {
		if (count[c]==-1) {
			count[c]=index;
		}
		else if (count[c]>=0) {
			count[c]=-2;
		}
		index++;
	}
	
	public char firstAppearOnce() {
		int minIndex=Integer.MAX_VALUE;
		char c='\0';//空字符
		for(int i=0;i<count.length;i++)
		{
			if (count[i]>=0 && count[i]<minIndex) {
			{	c=(char)i;
				minIndex=count[i];
			}
			}
		}
		return c;
	}
}
