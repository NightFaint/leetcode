
public class Sum_64 {

	//使用逻辑与的短路特性
	public int sum_total(int n) {
		int sum=n;
		boolean b=n>0 && (sum+=sum_total(n-1))>0;
		return sum;
	}
	
	//数学公式
	public int sum2(int n) {
	    return  ((int)Math.pow(n, 2) + n) >> 1;
	}
}
