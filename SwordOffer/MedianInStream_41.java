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
		
		//总数目为奇数时插入最小堆	
		else if ((count & 1)==1) {
			//如果要存入的数比最大堆的最大值小，不能保证最小堆的数都大于最大堆
			//可先将其存入最大堆，然后把最大堆poll出最大值存入最小堆
			if (num<maxHeap.peek()) {
				maxHeap.offer(num);
				minHeap.offer(maxHeap.poll());
			}
			else {
				minHeap.offer(num);
			}
		}
		
		//当前数据流为偶数个时，存入最大堆
		else if ((count & 1)==0) {
			//如果要存入的数比最小堆的最小值大，不能保证最小堆的数都大于最大堆
			//可先存入最小堆，然后把最小堆poll的值存入最大堆
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
		//当数据流为奇数个时，最大堆比最小堆多1
		if ((count&1)==1) {
			return maxHeap.peek();
		}
		return (maxHeap.peek()+minHeap.peek())/2;
		
	}
}
