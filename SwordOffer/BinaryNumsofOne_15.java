
public class BinaryNumsofOne_15 {

	//右移版本
	public int rightNumberOf1(int n) {
		int count=0;
		while(n!=0)
		{
			if ((n&1)==1) {
				count++;
			}
			n>>>=1;
		}
		return count;
	}
	
	//左移版本
	public int leftNumberOf1(int n) {
		int count=0;
		int flag=1;
		while (flag!=0) {
			if ((n & flag)!=0) {
				count++;
			}
			flag<<=1;
		}
		return count;
	}
	
	/*
	 * 更为巧妙的方法
	 * 该数二进制表示的最低位就是1，比如数7，二进制表示为111，此时直接减去1即可；
	*最低位不为1，假设从右往左出现的第一个1，位置为m。则该数减去1后，位置m处的1会变成0，m之后所有的0都会变成1。比如数12，二进制表示为1100，减去1，先找到从右往左数的第一个1，这个位置的1变成0，其后的两个0变成1，即变成了1011。此时，如果将减去1后得到的1011和原来的1100相与，得到1000，相当于是将最右边的那个1变成了0。
	*也就是说：把一个整数减去1之后再与原来的整数做位与运算，得到的结果相当于将原整数的二进制表示中最右边的1变成0。
	 */
	public int bestNumberOf1(int n) {
		int count=0;
		while (n!=0) {
			n=n&(n-1);
			count++;
		}
		return count;
	}
}
