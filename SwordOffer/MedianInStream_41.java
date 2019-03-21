import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInStream_41 {

	PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
	PriorityQueue<Integer> minHeap=new PriorityQueue<>();
	
	private int count=0;
	
	public void insert(int num) {
		if (count==0) {
			maxHeap.offer(num);
		}
		
		//����ĿΪ����ʱ������С��	
		else if ((count & 1)==1) {
			//���Ҫ������������ѵ����ֵС�����ܱ�֤��С�ѵ�������������
			//���Ƚ���������ѣ�Ȼ�������poll�����ֵ������С��
			if (num<maxHeap.peek()) {
				maxHeap.offer(num);
				minHeap.offer(maxHeap.poll());
			}
			else {
				minHeap.offer(num);
			}
		}
		
		//��ǰ������Ϊż����ʱ����������
		else if ((count & 1)==0) {
			//���Ҫ�����������С�ѵ���Сֵ�󣬲��ܱ�֤��С�ѵ�������������
			//���ȴ�����С�ѣ�Ȼ�����С��poll��ֵ��������
			if (num>minHeap.peek()) {
				minHeap.offer(num);
				maxHeap.offer(minHeap.poll());
			}
			else {
				maxHeap.offer(num);
			}
		}
		count++;
	}
	
	public int getMedian() {
		//��������Ϊ������ʱ�����ѱ���С�Ѷ�1
		if ((count&1)==1) {
			return maxHeap.peek();
		}
		return (maxHeap.peek()+minHeap.peek())/2;
		
	}
}
