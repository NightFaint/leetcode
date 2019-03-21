import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 没有修改原数组
 * 最大堆：大小不超过k时，就不断存入元素，
 * 只要容量超过k，就剔除其中最大的元素，
 * 重复该过程，当遍历所有元素后，该容器中剩下的刚好就是最小的k个元素。
 */
public class GetLeastKNumbers_maxHeap_40 {

	public List<Integer> getLeastNumbers(int[] nums,int k) {
		List<Integer> list=new ArrayList<>();
		if (nums==null || nums.length==0) {
			return list;
		}
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b) -> b.compareTo(a));
		for(int i:nums)
		{
			maxHeap.offer(i);
			if (maxHeap.size()>k) {
				maxHeap.poll();
			}
		}
		list.addAll(maxHeap);
		return list;
		
	}
}
