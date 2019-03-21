import java.util.Arrays;

public class PlayCard_61 {

	/*
	 * 现将数组排列好
	 * 如果除了大小王外有重复的，不是顺子
	 * 除此外
	 * 大小王的数量大于等于间隔数量即为顺子
	 */
	public boolean isContinuous(int[] numbers) {
		if (numbers==null || numbers.length<5) {
			return false;
		}
		Arrays.sort(numbers);
		
		//统计大小王数量
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
	 * 五张牌组合成的顺子，都有哪些共性呢？
	 * 如果牌中没有大小王，那么23456, 56789等这样的组合才是顺子；
	 * 即五张牌中最大值和最小值的差始终是4，
	 * 且任意两张牌不重复；
	 * 现在假设有大小王（用0表示），02345、03467、00367都是顺子，
	 * 但03678、00378不是顺子。发现大小王可多次出现，
	 * 因此五张牌中0可以重复出现。
	 * 除开0之外，其他牌不能重复出现且最大值与最小值的差小于5。
	 * 综合以上两种情况，要想构成顺子，需要满足以下条件：
	*除开0之外，其他任意牌不得重复出现
	*除开0之外的其他牌，最大值和最小值的差要小于5
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
