import java.util.ArrayList;
import java.util.List;

public class TwoSum_57 {

	/*O(n)
	 * 设定两个指针，一个从左开始，一个从右开始
	 * 若array[left]+array[right]大于target
	 * 说明两者之和太大了，需要小一点
	 * 由于数组是递增排序，故把right向左移动能减少两者之和
	 * 太小了则移动left指针，让两者之和大点
	 * 相等时便得到了结果
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
