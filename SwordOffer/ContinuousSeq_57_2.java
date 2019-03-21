import java.util.ArrayList;
import java.util.List;

public class ContinuousSeq_57_2 {

	public List<List<Integer>> findContinuiusSeq(int sum) {
		List<List<Integer>> list=new ArrayList<>();
		if (sum<3) {
			return list;
		}
		
		int small=1;
		int big=2;
		int mid=(1+sum)/2;
		int curSum=small+big;
		
		while(small<mid)
		{
			if (curSum==sum) {
				list.add(addList(small, big));
			}
			
			while(curSum>sum && small<mid)
			{
				curSum-=small;
				small++;

			}
			
			if (curSum==sum) {
				list.add(addList(small, big));
			}
			big++;
			curSum+=big;
		}
		return list;
	}
	
	private List<Integer> addList(int small,int big) {
		List<Integer> list=new ArrayList<>();
		for(int i=small;i<=big;i++)
			list.add(i);
		return list;
	}
}
