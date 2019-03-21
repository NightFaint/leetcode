import java.util.ArrayList;
import java.util.List;

public class TwoSum_57 {

	/*O(n)
	 * �趨����ָ�룬һ������ʼ��һ�����ҿ�ʼ
	 * ��array[left]+array[right]����target
	 * ˵������֮��̫���ˣ���ҪСһ��
	 * ���������ǵ������򣬹ʰ�right�����ƶ��ܼ�������֮��
	 * ̫С�����ƶ�leftָ�룬������֮�ʹ��
	 * ���ʱ��õ��˽��
	 */
	public List<Integer> twoSum(int[] array,int target) {
		List<Integer> list=new ArrayList<>();
		if (array==null || array.length<=1) {
			return list;
		}
		
		int left=0;
		int right=array.length-1;
		
		while(left<right)
		{
			int twoSum=array[left]+array[right];
			if (twoSum == target) {
				list.add(array[left]);
				list.add(array[right]);
				break;
			}
			else if (twoSum>target) {
				right--;
			}
			else {
				left++;
			}
		}
		return list;
	}
}
