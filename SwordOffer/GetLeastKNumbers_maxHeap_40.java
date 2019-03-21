import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * û���޸�ԭ����
 * ���ѣ���С������kʱ���Ͳ��ϴ���Ԫ�أ�
 * ֻҪ��������k�����޳���������Ԫ�أ�
 * �ظ��ù��̣�����������Ԫ�غ󣬸�������ʣ�µĸպþ�����С��k��Ԫ�ء�
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
