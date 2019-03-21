import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMax_59_2 {
	
	private class InternalData
	{
		private int number;
		private int index;
		
		public InternalData(int number,int index) {
			// TODO Auto-generated constructor stub
			this.index=index;
			this.number=number;
		}
		
		public int getNumber() {
			return number;
		}
		
		public int getIndex() {
			return index;
		}
	}

	int currentIndex;
	LinkedList<InternalData> datas;
	LinkedList<InternalData> maximums;
	
	public void offer(int number) {
		while (!maximums.isEmpty() && number>maximums.peekLast().getNumber()) {
			maximums.pollLast();
		}
		
		InternalData data=new InternalData(number, currentIndex);
		datas.offerLast(data);
		maximums.offerLast(data);
		
		++currentIndex;
	}
	
	public 	void poll() throws Exception {
		if (maximums.isEmpty()) {
			throw new RuntimeException("队列已空");
		}
		
		if (datas.peekFirst().index==maximums.peekFirst().index) {
			maximums.pollFirst();
		}
		
		datas.pollFirst();
	}
	
	public int  max() {
		if (maximums.isEmpty()) {
			throw new RuntimeException("队列已空");
		}
		return maximums.peekFirst().getNumber();
	}
}


