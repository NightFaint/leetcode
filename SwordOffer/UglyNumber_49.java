
public class UglyNumber_49 {

	/*
	 * �趨������t2��t3��t3ר�����ڷֱ��2��3��5��ˣ�
	 * ĳ��ѡ����ѡ����ti����ôti�ӳ���������ѡ����һ������
	 * �´��ٺ�i�������һ���µĺ�ѡ����������û�б�ѡ�еģ�
	 * �´μ�������Ƚϡ������ܱ�֤��һ������һ����������ѡ���У�
	 * ����������ѡ������С���Ǹ���
	 */
	public int  uglyNumber(int index) {
		if (index<=0) {
			return 0;
		}
		
		int t2=0;
		int t3=0;
		int t5=0;
		int[] res=new int[index];
		res[0]=1;
		for(int i=1;i<index;i++)
		{
			int m2=res[t2]*2;
			int m3=res[t3]*3;
			int m5=res[t5]*5;
			res[i]=Math.min(m2, Math.min(m3, m5));
			
//			 ������if,else if�滻����Ϊm2,m3,m5�п�����ȣ���ʱ����Ҫ������һ��
			if (res[i]==m2) {
				t2++;
			}
			if (res[i]==m3) {
				t3++;
			}
			if (res[i]==m5) {
				t5++;
			}
		}
		return res[index-1];
	}
	
	public static void main(String[] args) {
		UglyNumber_49 test=new UglyNumber_49();
		int result=test.uglyNumber(1200);
		System.out.println(result);
	}
}
