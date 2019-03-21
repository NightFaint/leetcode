
public class AppearOnceInStream_50 {

	private int[] count=new int[256];//ͳ���ַ�����
	private int index;//��¼�ǵڼ���������ַ�
	
	public AppearOnceInStream_50() {
		// TODO Auto-generated constructor stub
		for(int i=0;i<count.length;i++)
			count[i]=-1;
	}
	
	// ģ���ȡ�ַ����е���һ���ַ�
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
		char c='\0';//���ַ�
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
