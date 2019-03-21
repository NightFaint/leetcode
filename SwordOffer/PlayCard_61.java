import java.util.Arrays;

public class PlayCard_61 {

	/*
	 * �ֽ��������к�
	 * ������˴�С�������ظ��ģ�����˳��
	 * ������
	 * ��С�����������ڵ��ڼ��������Ϊ˳��
	 */
	public boolean isContinuous(int[] numbers) {
		if (numbers==null || numbers.length<5) {
			return false;
		}
		Arrays.sort(numbers);
		
		//ͳ�ƴ�С������
		int joker=0;
		for(int number:numbers)
		{
			if (number==0) {
				joker++;
			}
		}
		
		System.out.println("joker="+joker);
		
		int gap=0;
		for(int i=numbers.length-1;i>joker;i--)
		{
			if (numbers[i]==numbers[i-1]) {
				return false;
			}
			gap+=numbers[i]-numbers[i-1]-1;
			
		}
		return joker>=gap;	
	}
	
	/*
	 * ��������ϳɵ�˳�ӣ�������Щ�����أ�
	 * �������û�д�С������ô23456, 56789����������ϲ���˳�ӣ�
	 * �������������ֵ����Сֵ�Ĳ�ʼ����4��
	 * �����������Ʋ��ظ���
	 * ���ڼ����д�С������0��ʾ����02345��03467��00367����˳�ӣ�
	 * ��03678��00378����˳�ӡ����ִ�С���ɶ�γ��֣�
	 * �����������0�����ظ����֡�
	 * ����0֮�⣬�����Ʋ����ظ����������ֵ����Сֵ�Ĳ�С��5��
	 * �ۺ��������������Ҫ�빹��˳�ӣ���Ҫ��������������
	*����0֮�⣬���������Ʋ����ظ�����
	*����0֮��������ƣ����ֵ����Сֵ�Ĳ�ҪС��5
	 */
	
	public boolean isContinuous2(int[] numbers) {
		if (numbers==null || numbers.length<5) {
			return false;
		}
		int[] count=new int[14];
		int max=14;
		int min=-1;
		
		for(int number:numbers)
		{
			count[number]++;
			if (number!=0) {
				if (count[number]>1) {
					return false;
				}
				if (number>max) {
					max=min;
				}
				if (number<min) {
					min=number;
				}
			}
		}
		
		return max-min<5;
	}
	public static void main(String[] args) {
		PlayCard_61 test=new PlayCard_61();
		int[] test1= {0,0,2,4,6};
		System.out.println(test.isContinuous(test1));
	}
}
