
public class DigitAtIndex_44 {

	public int digitAtIndex(int index) {
		if (index<0) {
			return -1;
		}
		int digits=1;
		while(true)
		{
			int numbers=countOfInteger(digits);
			if (index < digits*numbers) {
				return digitAtIndex(index, digits);
			}
			index-=digits*numbers;
			digits++;
		}
	
	}
	
	
	private int  digitAtIndex(int index,int digits) {
		int number=beginNum(digits)+index/digits;
		int indexFromRight=digits-index%digits;
		for(int i=1;i<indexFromRight;i++)
		{
			number=number/10;
		}
		return number%10;
		
	}
	
	/*
	 * 第一位digits位数
	 */
	private int beginNum(int digits) {
		if (digits==1) {
			return 0;
		}
		return (int)Math.pow(10, digits-1);	
	}
	
	/*
	 * digits位数总共有多少个
	 */
	private int countOfInteger(int digits)
	{
		if (digits==1) {
			return 10;
		}
		return (int)Math.pow(10, digits-1);
	}
}
