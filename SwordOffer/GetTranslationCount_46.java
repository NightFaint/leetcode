
public class GetTranslationCount_46 {

	/*
	 * 如果自下而上，从小的结果出发，保存每一步计算的结果，以供下一步使用，也就是我们按照从右到左的顺序翻译。
	 * f(i) = f(i+1) + g(i, i+1)f(i+2), 0 <= i < n
	 * 对于上面的公式，也就是先求出f(n -1)，
	 * 然后求出f(n -2)，
	 * 之后根据这两个值求出f(n -3)，然后根据f(n-2)和f(n -3)求出f(n -4)一直往左直到求出f(0)
	 */
	public int getTranslationCount(int number) {
		if (number<0) {
			return 0;
		}
		String numberInString=String.valueOf(number);
		return getTranslationCount(numberInString);
	}
	
	private int getTranslationCount(String number) {
		int len=number.length();
		int[] counts=new int[len];
		int count=0;
		for(int i=len-1;i>=0;i--)
		{
			if (i<len-1) {
				count=counts[i+1];
			}
			else {
				count=1;
			}
			if (i<len-1) {
				int digit1=number.charAt(i)-'0';
				int digit2=number.charAt(i+1)-'0';
				int converted=digit1*10+digit2;
				if (converted>=10 && converted<=25) {
					if (i<len-2) {
						count+=counts[i+2];
					}
					else {
						count+=1;
					}
				}
			}
			counts[i]=count;
		}
		
		return counts[0];
		}
}
