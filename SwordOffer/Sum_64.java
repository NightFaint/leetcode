
public class Sum_64 {

	//ʹ���߼���Ķ�·����
	public int sum_total(int n) {
		int sum=n;
		boolean b=n>0 && (sum+=sum_total(n-1))>0;
		return sum;
	}
	
	//��ѧ��ʽ
	public int sum2(int n) {
	    return  ((int)Math.pow(n, 2) + n) >> 1;
	}
}
