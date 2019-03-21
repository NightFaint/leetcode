
public class MaxDiff_63 {

	//O(n)
	public int maxDiff(int[] numbers) {
		if (numbers==null || numbers.length<2) {
			return -1;
		}
		
		int min=numbers[0];//记录最小值
		int maxDiff=numbers[1]-min;//记录最大利润
		
		for(int i=2;i<numbers.length;i++)
		{
			//遍历数组，寻找低价
			if (numbers[i-1]<min) {
				min=numbers[i-1];
			}
			
			int currentDiff=numbers[i]-min;
			if (maxDiff<currentDiff) {
				maxDiff=currentDiff;
			}
		}
		return maxDiff;
	}
}
