
public class MaxDiff_63 {

	//O(n)
	public int maxDiff(int[] numbers) {
		if (numbers==null || numbers.length<2) {
			return -1;
		}
		
		int min=numbers[0];//��¼��Сֵ
		int maxDiff=numbers[1]-min;//��¼�������
		
		for(int i=2;i<numbers.length;i++)
		{
			//�������飬Ѱ�ҵͼ�
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
