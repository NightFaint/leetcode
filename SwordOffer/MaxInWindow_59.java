import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;


public class MaxInWindow_59 {

	/*
	 * 使用双端队列
	 * 只将有可能成为滑动窗口中的最大值的元素入列。
	 * 即将要入列的的元素比队列中哪些元素大或者相等，就将那些元素先从队列中删除，然后再入列新元素；
	 *队列头的最大值如果位于滑动窗口之外，则需要将队列头的最大值从队列中删除；
	 *当前下标加上1（因为下标从0开始计）等于窗口宽度的时候就可以开始统计滑动窗口的最大值了
	 */
	public ArrayList<Integer> maxInWindow(int[] array,int size) {

		ArrayList<Integer> list=new ArrayList<>();
		if (array==null || array.length<size || size<=0) {
			return list;
		}
		
		Deque<Integer> qDeque=new LinkedList<>();
		for(int i=0;i<array.length;i++)
		{
			while(!qDeque.isEmpty() && array[i] > array[qDeque.peekLast()])
				qDeque.pollLast();
			
			if (!qDeque.isEmpty() && i-qDeque.peekFirst()>=size) {
				qDeque.pollFirst();
			}
			
			qDeque.offerLast(i);
			
			if (i+1>=size) {
				list.add(array[qDeque.peekFirst()]);
			}
		}
		return list;
	}
}
