
public class UglyNumber_49 {

	/*
	 * 设定三个数t2、t3、t3专门用于分别和2、3、5相乘，
	 * 某次选择中选走了ti，那么ti从丑数集合中选择下一个数，
	 * 下次再和i相乘生成一个新的候选丑数，本次没有被选中的，
	 * 下次继续参与比较。这样能保证下一个丑数一定在三个候选项中，
	 * 且是三个候选项中最小的那个。
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
			
//			 不能用if,else if替换，因为m2,m3,m5有可能相等，此时都需要移向下一项
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
