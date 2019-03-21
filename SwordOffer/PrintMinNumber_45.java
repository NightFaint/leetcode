import java.util.ArrayList;
import java.util.List;

public class PrintMinNumber_45 {

	//O(nlgn)
	public String printMinNum(int[] nums) {
		if (nums==null || nums.length==0) {
			return "";
		}
		
		List<Integer> list=new ArrayList<>();
		for(int i:nums)
			list.add(i);
		list.sort((a,b)-> (a+""+b).compareTo(b+""+a));//O(nlgn)
		StringBuilder sb=new StringBuilder();
		for(Integer i:list)
			sb.append(i);
		return sb.toString();
	}
}
